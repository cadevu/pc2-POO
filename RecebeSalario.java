package br.com.prog2.trabalho2;
import javax.swing.JOptionPane;

public class RecebeSalario {

	public static void main(String[] args) {
		
	String sal ="";
	Salario[] salarios = new Salario[10];
	byte i =0;
	do {
		sal = (JOptionPane.showInputDialog("Digite o salário: "));
		if (sal.equals("0")) {
			break;
		}
		String dep = (JOptionPane.showInputDialog("Digite o número de dependentes: "));
		Double salBruto = Double.parseDouble(sal);
		Double dependentes = Double.parseDouble(dep);
		Salario salario1 = new Salario();
		salario1.salario = salBruto;
		salario1.numDependentes = dependentes;		
		if (salario1.salario < 1212.00) {
			salario1.inss = salario1.salario * 0.075;
		}else if (salario1.salario > 1212.00 && salario1.salario < 2427.35) {
			salario1.inss = salario1.salario*0.09;
		}else if (salario1.salario > 2427.35 && salario1.salario < 3641.03) {
			salario1.inss = salario1.salario*0.12;
		}else if (salario1.salario > 3641.03 && salario1.salario < 7087.22) {
			salario1.inss = salario1.salario*0.14;
		}else {
			salario1.inss = 992.22;
			
		}
		if(salario1.salario <=1903.98) {
			salario1.irpf = 0.0;
			salario1.parcela=0.0;
			salario1.aliquota=0.0;
		}else if ((salario1.salario-salario1.inss-(salario1.numDependentes*189.59)) > 1903.98 && (salario1.salario-salario1.inss-(salario1.numDependentes*189.59)) <=2826.65) {
			salario1.aliquota = 0.075;
			salario1.parcela = 142.8;
		}else if ((salario1.salario-salario1.inss-(salario1.numDependentes*189.59)) > 2826.65 && (salario1.salario-salario1.inss-(salario1.numDependentes*189.59)) <= 3751.05) {
			salario1.aliquota = 0.15;
			salario1.parcela = 354.8;
		}else if ((salario1.salario-salario1.inss-(salario1.numDependentes*189.59)) > 3751.05 && (salario1.salario-salario1.inss-(salario1.numDependentes*189.59)) <= 4664.68) {
			salario1.aliquota = 0.225;
			salario1.parcela = 636.13;
		}else {
			salario1.aliquota = 0.275;
			salario1.parcela = 869.36;
			// na realidade é salariobruto - inss - dependentes 
		}
		salario1.irpf = (salario1.aliquota* (salario1.salario - salario1.inss - salario1.numDependentes*189.59)) - salario1.parcela;
		salario1.salarioLiquido = salario1.salario - salario1.inss - salario1.irpf;
		salarios[i] = salario1;
		i++;
	}
	while (!sal.equals("0"));
	for (byte j = 0;j<i;j++) {
		System.out.println(salarios[j].salario);
		System.out.println(salarios[j].numDependentes);
		System.out.println(salarios[j].inss);
		System.out.println(salarios[j].aliquota);
		System.out.println(salarios[j].parcela);
		System.out.println(salarios[j].irpf);
		System.out.println(Math.round(salarios[j].salarioLiquido*100.0)/100.0);
	}
	}

}
