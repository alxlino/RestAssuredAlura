package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;

public class UsuariosWSTest {
//	@Test
//	public void deveRetornarListaDeUsuariosXml() {
//		
//		//http://localhost:8080/usuarios?_format=xml
//		
//		XmlPath path = given().header("accept","application/xml")
//				.get("/usuarios?_format=xml").andReturn().xmlPath();
//		
//        List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);
//		
//		Usuario esperado1 = new Usuario(1L,"Mauricio Aniche","mauricio.aniche@caelum.com.br");
//		Usuario esperado2 = new Usuario(2L,"Guilherme Silveira","guilherme.silveira@caelum.com.br");
//		
//		assertEquals(esperado1,usuarios.get(0));
//		assertEquals(esperado2,usuarios.get(1));
//	}
	
//	@Test
//	public void deveRetornarUsuarioPorIDJson() {
//		
//		//http://localhost:8080/usuarios/show?usuario.id=1&_format=json
//		//http://localhost:8080/leiloes/show?leilao.id=1&_format=json
//		
//		JsonPath path = given()
//				.header("accept","application/json")
//				.parameter("usuario.id", 1)
//				.get("/usuarios/show")
//				.andReturn()
//				.jsonPath();
//		
//		Usuario usuario = path.getObject("usuario",Usuario.class);
//		Usuario esperado1 = new Usuario(1L,"Mauricio Aniche","mauricio.aniche@caelum.com.br");
//		assertEquals(esperado1,usuario);
//		
//	}
	
//	@Test
//	public void deveRetornarLeilaoPorIDJson() {
//		
//		//http://localhost:8080/usuarios/show?usuario.id=1&_format=json
//		//http://localhost:8080/leiloes/show?leilao.id=1&_format=json
//		
//		JsonPath path = given()
//				.header("accept","application/json")
//				.parameter("leilao.id", 1)
//				.get("/leiloes/show")
//				.andReturn()
//				.jsonPath();
//		
//		Leilao leilao = path.getObject("leilao", Leilao.class);
//		Usuario usuario = new Usuario(1L,"Mauricio Aniche","mauricio.aniche@caelum.com.br");
//		Leilao leilaoEsperado = new Leilao(1L,"Geladeira", 800.0, usuario, false);
//		assertEquals(leilaoEsperado, leilao);
//		
//	}
	
	@Test
    public void deveAdicionarUmUsuarioXml() {
        Usuario joao = new Usuario("Joao da Silva", "joao@dasilva.com");

        XmlPath retorno = 
            given()
                .header("Accept", "application/xml")
                .contentType("application/xml")
                .body(joao)
            .expect()
            	.statusCode(200)
            .when()
                .post("/usuarios")
            .andReturn()
                .xmlPath();

        Usuario resposta = retorno.getObject("usuario", Usuario.class);

        assertEquals("Joao da Silva", resposta.getNome());
        assertEquals("joao@dasilva.com", resposta.getEmail());

    }
	
//	@Test
//    public void deveRetornarListaDeUsuariosJson() {
//        JsonPath path = given()
//                .header("Accept", "application/json")
//                .get("/usuarios")
//                .andReturn().jsonPath();
//
//        List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);
//
//        Usuario esperado1 = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
//        Usuario esperado2 = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
//
//        assertEquals(esperado1, usuarios.get(0));
//        assertEquals(esperado2, usuarios.get(1));
//
//    }
}
