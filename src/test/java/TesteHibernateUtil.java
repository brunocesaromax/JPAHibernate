import dao.DaoGeneric;
import model.Telefone;
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

    @Test
    public void testQueryList() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        List<Usuario> usuarios = daoGeneric.getEntityManager().createQuery(
                "FROM Usuario WHERE nome = 'Jessica'").getResultList();

        for (Usuario usuario : usuarios) {

            System.out.println(usuario);
            System.out.println("------------------------------------------------");
        }
    }

    @Test
    public void testQueryListMaxResult() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        List<Usuario> usuarios = daoGeneric.getEntityManager().createQuery(
                "FROM Usuario ORDER BY nome").setMaxResults(2).getResultList();

        for (Usuario usuario : usuarios) {

            System.out.println(usuario);
            System.out.println("------------------------------------------------");
        }
    }

    @Test
    public void testQueryListWithParameter() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        List<Usuario> usuarios = daoGeneric.getEntityManager().createQuery(
                "FROM Usuario WHERE nome = :nome OR idade = :idade")
                .setParameter("nome", "Jessica")
                .setParameter("idade", 22)
                .getResultList();

        for (Usuario usuario : usuarios) {

            System.out.println(usuario);
            System.out.println("------------------------------------------------");
        }
    }

    @Test
    public void testQuerySumIdades() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        Long sumIdade = (Long) daoGeneric.getEntityManager().createQuery(
                "SELECT SUM(obj.idade) from Usuario obj").getSingleResult();

        Double avgIdades = (Double) daoGeneric.getEntityManager().createQuery(
                "SELECT AVG(obj.idade) from Usuario obj").getSingleResult();

        Long numUsuarios = (Long) daoGeneric.getEntityManager().createQuery(
                "SELECT COUNT(obj.id) from Usuario obj").getSingleResult();

        System.out.println("Soma das idades = " + sumIdade);
        System.out.println("Média das idades = " + avgIdades);
        System.out.println("Numero de usuarios = " + numUsuarios);
    }

    @Test
    public void testNamedQuery1() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        List<Usuario> usuarios = daoGeneric.getEntityManager().createNamedQuery("Usuario.findAll").getResultList();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    @Test
    public void testNamedQuery2() {
        DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

        List<Usuario> usuarios = daoGeneric.getEntityManager().createNamedQuery("Usuario.findByNome")
                .setParameter("nome", "Jessica")
                .getResultList();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    @Test
    public void testeSaveOrUpdateTelefone() {
        DaoGeneric daoGeneric = new DaoGeneric();

        Usuario usuario = (Usuario) daoGeneric.find(3L, Usuario.class);

        Telefone telefone = new Telefone();
        telefone.setNumero("32889999");
        telefone.setTipo("Casa");
        telefone.setUsuario(usuario);

        daoGeneric.saveOrUpdate(telefone);
    }

    @Test
    public void testeFindTelefonesOfUsuario() {
        DaoGeneric daoGeneric = new DaoGeneric();

        Usuario usuario = (Usuario) daoGeneric.find(3L, Usuario.class);

        for (Telefone fone : usuario.getTelefones()) {

            System.out.println(fone.getNumero());
            System.out.println(fone.getTipo());
            System.out.println(fone.getUsuario());
            System.out.println("-------------------------------------------------");

        }
    }
}
