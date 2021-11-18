package com.pucgoias.locadoraveiculos;

import com.pucgoias.locadoraveiculos.domain.Aluguel;
import com.pucgoias.locadoraveiculos.domain.Automovel;
import com.pucgoias.locadoraveiculos.domain.Cliente;
import com.pucgoias.locadoraveiculos.domain.Funcionario;
import com.pucgoias.locadoraveiculos.repositories.AluguelRepository;
import com.pucgoias.locadoraveiculos.repositories.AutomovelRepository;
import com.pucgoias.locadoraveiculos.repositories.ClienteRepository;
import com.pucgoias.locadoraveiculos.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

		Aluguel al1 = new Aluguel(null, LocalDate.now(), LocalDate.of(2020, 12, 01), 12, new BigDecimal(123.89));


		Cliente c1 = new Cliente(null, "JORIVER", LocalDate.now(), "033.545.611-14", "Avenida Universitaria", "3245221333", "1234567890", List.of(al1));


		Funcionario f1 = new Funcionario(null, "RONALDO", LocalDate.now(), "283.595.901-76", "PERDEDOR DE TEMPO", "00000066666", List.of(al1));


		Automovel a1 = new Automovel(null, BigDecimal.TEN, "PUC666", "PUC CHEVETE", "CHEVROLET", "12", "grande", "diesel", "automatico", "LOCADO", BigDecimal.valueOf(45.8), List.of(al1));

		Aluguel aluguelSalvo = aluguelRepository.save(al1);
		Automovel automovelSalvo = automovelRepository.save(a1);
		Cliente clienteSalvo = clienteRepository.save(c1);
		Funcionario funcionarioSalvo = funcionarioRepository.save(f1);


		System.out.println(aluguelSalvo.toString());
		System.out.println(clienteSalvo.toString());
		System.out.println(funcionarioSalvo.toString());
		System.out.println(automovelSalvo.toString());



	}
}
