import dao.DaoGeneric;
import model.Usuario;
import org.junit.Test;

public class TesteHibernateUtil {

    @Test
    public void testeHibernateUtil(){
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        Usuario usuario = new Usuario();

        usuario.setIdade(23);
        usuario.setNome("Bruno César Vicente");
        usuario.setEmail("brunocesar.oc@hotmail.com");
        usuario.setSenha("moana123");

        daoGeneric.save(usuario);
    }
}
