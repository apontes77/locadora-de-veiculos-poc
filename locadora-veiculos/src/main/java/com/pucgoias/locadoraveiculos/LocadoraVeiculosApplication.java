package com.pucgoias.locadoraveiculos;

import com.pucgoias.locadoraveiculos.domain.*;
import com.pucgoias.locadoraveiculos.domain.enums.StatusLocacao;
import com.pucgoias.locadoraveiculos.domain.enums.TipoCambio;
import com.pucgoias.locadoraveiculos.domain.enums.TipoCombustivel;
import com.pucgoias.locadoraveiculos.repositories.AluguelRepository;
import com.pucgoias.locadoraveiculos.repositories.AutomovelRepository;
import com.pucgoias.locadoraveiculos.repositories.ClienteRepository;
import com.pucgoias.locadoraveiculos.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
@AllArgsConstructor
public class LocadoraVeiculosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraVeiculosApplication.class, args);
	}

	private AluguelRepository aluguelRepository;
	private AutomovelRepository automovelRepository;
	private ClienteRepository clienteRepository;
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Aluguel al1 = new Aluguel(null, LocalDate.now(), LocalDate.of(2020, 12, 01), 12, formataDecimal(new BigDecimal(123.89)));


		Cliente c1 = new Cliente(null, "Bob Green", LocalDate.now(), "033.545.611-14", "Avenida Universitaria, SN", "3245221333", "1234567890", List.of(al1));


		Funcionario f1 = new Funcionario(null, "Rudolph James", LocalDate.now(), "283.595.901-76", "PROFESSOR", "00000066666", List.of(al1));


		Automovel a1 = new Automovel(null, formataDecimal(BigDecimal.TEN), "PRV1278", "MERIVA", "CHEVROLET", "12", "GRANDE",
									TipoCombustivel.GASOLINA, TipoCambio.AUTOMATIZADO_DUPLA_EMBREAGEM, StatusLocacao.LOCADO,
									formataDecimal(BigDecimal.valueOf(45.8)), List.of(al1));

		Aluguel aluguelSalvo = aluguelRepository.save(al1);
		Automovel automovelSalvo = automovelRepository.save(a1);
		Cliente clienteSalvo = clienteRepository.save(c1);
		Funcionario funcionarioSalvo = funcionarioRepository.save(f1);

		System.out.println(aluguelSalvo.toString());
		System.out.println(clienteSalvo.toString());
		System.out.println(funcionarioSalvo.toString());
		System.out.println(automovelSalvo.toString());
	}

	public BigDecimal formataDecimal(BigDecimal vlrFator) {
		return vlrFator.setScale(2, BigDecimal.ROUND_UP);
	}
}
