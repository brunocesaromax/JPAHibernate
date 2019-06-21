import dao.DaoGeneric;
import model.Usuario;
import org.junit.Test;

import java.util.List;

public class TesteHibernateUtil {

    @Test
    public void testeSaveOrUpdate() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        Usuario usuario = new Usuario();
//        Usuario usuario = daoGeneric.find(3L, Usuario.class);
        usuario.setIdade(33);
        usuario.setNome("Cláudia");
        usuario.setEmail("claudiaveia123@hotmail.com");
        usuario.setSenha("moana123");

        daoGeneric.saveOrUpdate(usuario);
    }

    @Test
    public void testSearch() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        Usuario usuario = new Usuario();

        usuario.setId(1L);
        usuario = daoGeneric.find(usuario);

        System.out.println(usuario.toString());
    }

    @Test
    public void testSearch2() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        Usuario usuario = new Usuario();

        usuario.setId(1L);
        usuario = daoGeneric.find(2L, Usuario.class);

        System.out.println(usuario.toString());
    }

    @Test
    public void testDelete() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        Usuario usuario = daoGeneric.find(1L, Usuario.class);

        daoGeneric.deleteById(usuario);
    }

    @Test
    public void testFindAll() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        List<Usuario> usuarios = daoGeneric.findAll(Usuario.class);

        for (Usuario usuario : usuarios) {

            System.out.println(usuario.toString());
            System.out.println("------------------------------------------------");
        }
    }
}
