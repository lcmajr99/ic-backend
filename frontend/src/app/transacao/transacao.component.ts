import { AtivoService } from './../services/ativos.service';
import { element } from 'protractor';
import { TransacaoService } from './../services/transacao.service';
import { UsuarioAux } from './../models/usuarioAux.model';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Usuario } from './../models/usuario.model';
import { AppComponent } from '../app.component';
import { CadastroService } from '../services/cadastro.service';
import { Transacao } from '../models/transacao.model';


import {
  Chart,
  ChartDataSets,
  ChartOptions,
  PluginServiceRegistrationOptions,
} from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { Ativo } from '../models/ativo.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transacao',
  templateUrl: './transacao.component.html',
  styleUrls: ['./transacao.component.css'],
})
export class TransacaoComponent implements OnInit {
  @ViewChild('meuCanvas', { static: true }) elemento: ElementRef;

  // lineChartData: ChartDataSets[] = [
  //   { data: [85, 72, 78, 75, 77, 75], label: 'Crude oil prices' },
  // ];

  // lineChartLabels: Label[] = ['January', 'February', 'March', 'April', 'May', 'June'];

  // lineChartOptions = {
  //   responsive: true,
  // };

  // lineChartColors: Color[] = [
  //   {
  //     borderColor: 'black',
  //     backgroundColor: 'rgba(255,255,0,0.28)',
  //   },
  // ];

  // lineChartLegend = true;
  // lineChartPlugins = [];
  // lineChartType = 'line';

  // options: {
  //   datasource: {
  //     url: '../../assets/csv/PETR4_M5.csv';
  //   }
  //
  ativo: Ativo[];
  ativo2: Ativo[];
  cadastro?: Usuario;
  email?: String;
  tipo: String;
  qtdTransacao: number[];
  maisResultado: number;
  vendeTudo: number;
  vendeTudo2: number;
  saldo: number;
  qualAtivo: String;
  indicativo: String;
  momento: number;
  quantidade: number;
  usuarioAux: UsuarioAux;
  teste: number = 0;
  maxMomento: number;

  constructor(
    private appcomponent: AppComponent,
    private service: CadastroService,
    private service2: TransacaoService,
    private service3: AtivoService,
    private router: Router
  ) {}

  operar() {
    const valorEmitir: Transacao = {
      valor: this.ativo[0].valor,
      tipo: this.tipo,
      quantidade: this.quantidade,
      usuario: this.cadastro,
    };
    this.service2.efetuar(valorEmitir).subscribe(
      (resultado) => {
        alert('Transação efetuado com sucesso');
        document.location.reload(true);

        this.limparCampos();
      },
      (error) => {
        alert('Erro ao efetuar a Transação');
      }
    );
  }

  mudarTempo() {
    const valorEmitir: Usuario = {
      id: this.cadastro.id,
      nome: this.cadastro.nome,
      email: this.cadastro.email,
      qtdAcao: this.cadastro.qtdAcao,
      momento: this.momento,
      saldo: this.cadastro.saldo,
    };
    if (this.momento > this.maxMomento) {
      alert('Atenção o limite máximo do momento é:  ' + this.maxMomento);
    } else {
      if (this.momento < 1) {
        alert('Atenção o limite minimo do momento é:  1');
      } else {
        this.service.alterarTempo(valorEmitir).subscribe(
          (resultado) => {
            alert('Mudança temporal efetuada com sucesso');
            this.momento = 0;
            document.location.reload(true);
          },
          (error) => {
            alert('Erro ao efetuar mudança temporal');
          }
        );
      }
    }
  }

  limparCampos() {
    this.tipo = '';
    this.quantidade = 0;
  }

  async getData() {
    const response = await fetch('../../assets/csv/BBAS3_DAILY.csv');
    const data = await response.text();
    const momentos = [];
    const valores = [];
    const rows = data.split('\n').slice(1);
    rows.forEach((row) => {
      const cols = row.split(',');
      momentos.push(cols[0]);
      valores.push(1 + parseFloat(cols[1]));
    });
    return { momentos, valores };
  }

  // async criaGrafico() {
  //   const globalTemps = await this.getData();

  //   new Chart(this.elemento.nativeElement, {
  //     type: 'line',
  //     data: {
  //       labels: globalTemps.momentos,
  //       datasets: [
  //         {
  //           data: globalTemps.valores,
  //           borderColor: '#00AEFF',
  //           fill: false,
  //         },
  //       ],
  //     },
  //     options: {
  //       legend: {
  //         display: false,
  //       },
  //     },
  //   });
  // }

  criaAlerta(ativo: Ativo[]) {
    if (ativo[1].valor > ativo[0].valor) {
      this.indicativo = 'Crescimento (Compra)';
    } else {
      this.indicativo = 'Encolhimento (Venda)';
    }
  }
  pegaAcao(momento: Number) {
    if(this.qualAtivo == 'bbas3'){
      this.service3.palpiteBBAS3(momento).subscribe((ativos: Ativo[]) => {
        console.log(ativos);
        this.ativo = ativos;
        this.criaAlerta(ativos);
      });
    }
    else{
      if(this.qualAtivo == 'petr4'){
        this.service3.palpite(momento).subscribe((ativos: Ativo[]) => {
          this.ativo = ativos;
          this.criaAlerta(ativos);
        });
      }
    }
    this.service3.valorReal(momento).subscribe((ativos: Ativo[]) => {

      this.ativo2 = ativos;
    });
  }

  buscaResultado() {
    this.service2.gerarResultado(this.cadastro.id).subscribe(
      (resultado: number[]) => {
        console.table(resultado);
        this.qtdTransacao = resultado;
        console.log('TABELA');
        console.table(this.qtdTransacao);

      },
      (error) => {
        alert('Erro ao gerar resultado');
      }
    );

  }
  buscaMaisInformacao() {
    this.service2.gerarMaisResultado(this.cadastro.id).subscribe(
      (resultado: number) => {
        this.maisResultado = resultado;
        this.vendeTudo = resultado + this.cadastro?.saldo;

      },
      (error) => {
        alert('Erro ao gerar resultado');
      }
    );


    this.service2.predicaoGerarMaisResultado(this.cadastro.id).subscribe(
      (resultado: number) => {
        this.maisResultado = resultado;
        this.vendeTudo2 = resultado + this.cadastro?.saldo;
      },
      (error) => {
        alert('Erro ao gerar resultado');
      }
    );

  }

  ngOnInit() {
    // this.criaGrafico();
    this.email = localStorage.getItem('email');
    this.qualAtivo = localStorage.getItem('ativo');
    this.service.especifico(this.email).subscribe((cadastros: Usuario) => {
      this.cadastro = cadastros;
      this.pegaAcao(cadastros.momento);
    });

    this.service3.todas().subscribe((ativos: Ativo[]) => {
      this.maxMomento = ativos.length;
    });
  }
}
