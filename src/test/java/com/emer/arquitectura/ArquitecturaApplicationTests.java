package com.emer.arquitectura;

import com.emer.arquitectura.aplicacion.manejador.ManejadorObtenerProducto;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.infraestructura.endpoint.EndpointObtenerProducto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EndpointObtenerProducto.class)
@Import(ManejadorObtenerProducto.class)
class ArquitecturaApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	ManejadorObtenerProducto manejadorObtenerProducto;

	@Test
	public void obtenerTodos() {
		Flux<Producto> prodcutos = Flux.just(new Producto("1", "Laptop","Test", "Asus", "Gamer", 1, 250.0, LocalDate.now(), "laptop.img"));
		Mockito.when(manejadorObtenerProducto.ejecutarObtenerTodos()).thenReturn(prodcutos);
		webTestClient.get()
				.uri("/productos/all")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$[0].id").isEqualTo("1");
	}


}
