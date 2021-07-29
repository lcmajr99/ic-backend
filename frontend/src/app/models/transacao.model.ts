import { Usuario } from './usuario.model';
import { UsuarioAux } from './usuarioAux.model';
export interface Transacao{

  valor: Number;
  tipo: String;
  quantidade: Number;
  usuario: Usuario;

}
