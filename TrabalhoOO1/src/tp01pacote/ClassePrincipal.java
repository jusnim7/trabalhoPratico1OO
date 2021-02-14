package tp01pacote;
import java.util.Scanner;

import javax.imageio.plugins.jpeg.JPEGQTable;

public class ClassePrincipal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//DECLARANDO AS VARIÁVEIS USADAS NO MÉTODO MAIN
		int valorMenu, anoLido1, indiceAno1, indiceMes1, qtdDiasDoMes1;
		int anoLido2, indiceAno2, indiceMes2, qtdDiasDoMes2;
		int anoLido3, indiceAno3, indiceMes3, qtdDiasDoMes3;
		int anoLido4, indiceAno4, indiceMes4, qtdDiasDoMes4;
		int anoLido5, indiceAno5, indiceMes5, qtdDiasDoMes5;
		int trueOrFalse =5;

		
		double temperaturaMedia, receberUmValor;
		
		String mesLido1, mesLido2, mesLido3, mesLido4, mesLido5;
		String fecharMenu;
		
		//CHAMANDO O OBJETO RECURSO
		Recursos armazenamento = new Recursos();


		armazenarPiEmTudo(armazenamento);
		
		while(true) {
			
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println("                 MENU DE OPÇÕES");
			System.out.println();
			System.out.println("*Digite o numero do menu que deseja acessar.");
			System.out.println();
			System.out.println("1 - Entrada das temperaturas em graus Celsius.");
			System.out.println("2 - Calculo da temperatura media.");
			System.out.println("3 - Calculo da temperatuda minima.");
			System.out.println("4 - Calculo da temperatura maxima.");
			System.out.println("5 - Relatório meteriologico.");
			System.out.println("6 - Encerrar o aplicativo.");
			System.out.println("------------------------------------------------");
			System.out.print("\nOpcao: ");
			
			valorMenu = input.nextInt();
			
			if(valorMenu < 1 || valorMenu > 6) { System.out.println("-Voce digitou uma opcao invalida. Tente novamente!"); 
			System.out.println();
			continue; 
			}
			
			if(valorMenu == 6) {
				
				System.out.println("Voce realmente deseja fechar o aplicativo? Digite 'sim' para confirmar ou 'nao' para voltar ao menu de opcoes.");
				fecharMenu = input.next();
				if(fecharMenu.equalsIgnoreCase("sim")) {
					System.exit(0);
				}else { continue; }
				
				
			}
			
			
			switch(valorMenu) {
			
			case 1:
				
				
				
				mesLido1 = pegarMes();
				anoLido1 = pegarAno();
				
				indiceAno1 = transformarAno(anoLido1);
				indiceMes1 = transformarMesLido(mesLido1, anoLido1);
				qtdDiasDoMes1 = pegarLetraC(mesLido1, anoLido1);
								
				//COLOCANDO DADOS PARA JAN 2020
				if(indiceAno1 == 9 && indiceMes1 == 0) {
					
					System.out.println("Esses dados ja estao definidos em nosso sistema.");
					break;
					
				}
				
				lerTemperaturas(armazenamento, indiceAno1, indiceMes1, qtdDiasDoMes1);
				
				break;
			
			case 2:
				
				//ESSE CASE 2 SE NAO PRECISAR PRINTAR E INUTIL
				mesLido2 = pegarMes();
				anoLido2 = pegarAno();
				
				indiceAno2 = transformarAno(anoLido2);
				indiceMes2 = transformarMesLido(mesLido2, anoLido2);
				qtdDiasDoMes2 = pegarLetraC(mesLido2, anoLido2);

				
				temperaturaMedia = fazerMediaDasTemperaturas(armazenamento, indiceAno2, indiceMes2, qtdDiasDoMes2);
				
				System.out.println();
				System.out.println();
				
				
				trueOrFalse = verificacaoDosDados(armazenamento, indiceAno2, indiceMes2, qtdDiasDoMes2);
				if(trueOrFalse == 1) { break; } 
				System.out.println("Temperatura media: "+temperaturaMedia+" °C");
				trueOrFalse = 5;
				
				voltarAoMenu();
				
				break;
				
			case 3:

				mesLido3 = pegarMes();
				anoLido3 = pegarAno();
				
				indiceAno3 = transformarAno(anoLido3);
				indiceMes3 = transformarMesLido(mesLido3, anoLido3);
				qtdDiasDoMes3 = pegarLetraC(mesLido3, anoLido3);
				
				trueOrFalse = verificacaoDosDados(armazenamento, indiceAno3, indiceMes3, qtdDiasDoMes3);
				if(trueOrFalse == 1) { break; } 
				acharTemperaturaMinima(armazenamento, indiceAno3, indiceMes3, qtdDiasDoMes3);
	
				
				break;
				
			case 4:
				
				mesLido4 = pegarMes();
				anoLido4 = pegarAno();
				
				indiceAno4 = transformarAno(anoLido4);
				indiceMes4 = transformarMesLido(mesLido4, anoLido4);
				qtdDiasDoMes4 = pegarLetraC(mesLido4, anoLido4);
				
				trueOrFalse = verificacaoDosDados(armazenamento, indiceAno4, indiceMes4, qtdDiasDoMes4);
				if(trueOrFalse == 1) { break; }
				acharTemperaturaMaxima(armazenamento, indiceAno4, indiceMes4, qtdDiasDoMes4);
				trueOrFalse = 5;
				
				break;
				
			case 5:
				
				mesLido5 = pegarMes();
				anoLido5 = pegarAno();
				
				indiceAno5 = transformarAno(anoLido5);
				indiceMes5 = transformarMesLido(mesLido5, anoLido5);
				qtdDiasDoMes5 = pegarLetraC(mesLido5, anoLido5);
				
				trueOrFalse = verificacaoDosDados(armazenamento, indiceAno5, indiceMes5, qtdDiasDoMes5);
				if(trueOrFalse == 1) { break; }
				relatorioMeteriologico(armazenamento, indiceAno5, indiceMes5, qtdDiasDoMes5);
				trueOrFalse = 5;
				
				break;
			
				
			case 6:
				
				System.exit(0);
			}
					
			
			
			
			
		}
		
		
	}
	
	//METODO PARA LER OS MESES
	public static String pegarMes() {
		
		Scanner input = new Scanner(System.in);
		
		String lendoMes;
		
		System.out.print("Entre com o mes em que deseja apurar os dados: ");
		lendoMes = input.next();

		while (!lendoMes.equalsIgnoreCase("Janeiro") && !lendoMes.equalsIgnoreCase("Fevereiro") && !lendoMes.equalsIgnoreCase("Março") && !lendoMes.equalsIgnoreCase("Abril") && !lendoMes.equalsIgnoreCase("Maio") && !lendoMes.equalsIgnoreCase("Junho") && !lendoMes.equalsIgnoreCase("Julho") && !lendoMes.equalsIgnoreCase("Agosto") && !lendoMes.equalsIgnoreCase("Setembro") && !lendoMes.equalsIgnoreCase("Outubro") && !lendoMes.equalsIgnoreCase("Novembro") && !lendoMes.equalsIgnoreCase("Dezembro")) {
			
			System.out.print("Voce digitou um mes invalido! Tente novamente: ");
			lendoMes = input.next();
		}
	

		return lendoMes;
	}

	
	//METODO PARA LER OS ANOS
	public static int pegarAno() {
		
		Scanner input = new Scanner(System.in);
		
		int year; 
		
		System.out.print("Agora entre com o ano que deseja: ");
		year = input.nextInt();
		
		while(year <= 2010 || year >= 2021) {
			
			System.out.print("Voce digitou um ano invalido. Escolha algum dos anos entre 2011 e 2020: ");
			year = input.nextInt();
	
		}
		
		return year;
	}
	
	
	//TRANSFORMANDO O ANO DIGITADO EM UM NUMERO QUE CABE NO VETOR DE 3 DIMENSOES
	public static int transformarAno(int year) {
		int indiceAno=0;
		
		if(2020 - year == 9) {indiceAno = 0;}
		else if(2020 - year == 8) {indiceAno = 1;}
		else if(2020 - year == 7) {indiceAno = 2;}
		else if(2020 - year == 6) {indiceAno = 3;}
		else if(2020 - year == 5) {indiceAno = 4;}
		else if(2020 - year == 4) {indiceAno = 5;}
		else if(2020 - year == 3) {indiceAno = 6;}
		else if(2020 - year == 2) {indiceAno = 7;}
		else if(2020 - year == 1) {indiceAno = 8;}
		else if(2020 - year == 0) {indiceAno = 9;}
		
		return indiceAno;
	}
	
	//TRANSFORMANDO O M DIGITADO EM UM NUMERO QUE CABE NO VETOR DE 3 DIMENSOES
	public static int transformarMesLido(String month, int year) {
		
		int indiceMes=0;
						
		if( month.equalsIgnoreCase("Janeiro")) { indiceMes = 0;}
		else if( month.equalsIgnoreCase("Fevereiro")) { indiceMes = 1;}
		else if( month.equalsIgnoreCase("Março")) { indiceMes = 2;}
		else if( month.equalsIgnoreCase("Abril")) { indiceMes = 3;}
		else if( month.equalsIgnoreCase("Maio")) { indiceMes = 4;}
		else if( month.equalsIgnoreCase("Junho")) { indiceMes = 5;}
		else if( month.equalsIgnoreCase("Julho")) { indiceMes = 6;}
		else if( month.equalsIgnoreCase("Agosto")) { indiceMes = 7;}
		else if( month.equalsIgnoreCase("Setembro")) { indiceMes = 8;}
		else if( month.equalsIgnoreCase("Outubro")) { indiceMes = 9;}
		else if( month.equalsIgnoreCase("Novembro")) { indiceMes = 10;}
		else if( month.equalsIgnoreCase("Dezembro")) { indiceMes = 11;}
		
		
		return indiceMes;
	}
	
	//PEGANDO OS DIAS DO MES PQ NAO DA PARA RETORNAR 2 NUMEROS NO OUTRO METODO
	public static int pegarLetraC(String month, int year) {
		
		
		int qtdDiasDoMes=0;
		
		if( year == 2012 || year == 2016 || year == 2020 ) {
				
		if( month.equalsIgnoreCase("Janeiro")) { qtdDiasDoMes = 31;}
		else if( month.equalsIgnoreCase("Fevereiro")) { qtdDiasDoMes = 29;}
		else if( month.equalsIgnoreCase("Março")) { qtdDiasDoMes = 31;}
		else if( month.equalsIgnoreCase("Abril")) { qtdDiasDoMes = 30;}
		else if( month.equalsIgnoreCase("Maio")) { qtdDiasDoMes = 31;}
		else if( month.equalsIgnoreCase("Junho")) { qtdDiasDoMes = 30;}
		else if( month.equalsIgnoreCase("Julho")) { qtdDiasDoMes = 31;}
		else if( month.equalsIgnoreCase("Agosto")) { qtdDiasDoMes = 31;}
		else if( month.equalsIgnoreCase("Setembro")) { qtdDiasDoMes = 30;}
		else if( month.equalsIgnoreCase("Outubro")) { qtdDiasDoMes = 31;}
		else if( month.equalsIgnoreCase("Novembro")) { qtdDiasDoMes = 30;}
		else if( month.equalsIgnoreCase("Dezembro")) { qtdDiasDoMes = 31;}
		
		} else { 
			
			if( month.equalsIgnoreCase("Janeiro")) { qtdDiasDoMes = 31;}
			else if( month.equalsIgnoreCase("Fevereiro")) { qtdDiasDoMes = 28;}
			else if( month.equalsIgnoreCase("Março")) { qtdDiasDoMes = 31;}
			else if( month.equalsIgnoreCase("Abril")) { qtdDiasDoMes = 30;}
			else if( month.equalsIgnoreCase("Maio")) { qtdDiasDoMes = 31;}
			else if( month.equalsIgnoreCase("Junho")) { qtdDiasDoMes = 30;}
			else if( month.equalsIgnoreCase("Julho")) { qtdDiasDoMes = 31;}
			else if( month.equalsIgnoreCase("Agosto")) { qtdDiasDoMes = 31;}
			else if( month.equalsIgnoreCase("Setembro")) { qtdDiasDoMes = 30;}
			else if( month.equalsIgnoreCase("Outubro")) { qtdDiasDoMes = 31;}
			else if( month.equalsIgnoreCase("Novembro")) { qtdDiasDoMes = 30;}
			else if( month.equalsIgnoreCase("Dezembro")) { qtdDiasDoMes = 31;}
			
			
			
			
		}
		
		return qtdDiasDoMes;
	
	}
	
	//LENDO AS TEMPERATURAS
	public static void lerTemperaturas(Recursos lerTemperaturas, int indiceAno, int indiceMes, int qtdDiasDoMes) {
		
		Scanner input = new Scanner(System.in);
		int l = 1;
		
		for(int k=0; k < qtdDiasDoMes; k++) {
			
			
			System.out.print("Dia "+l+": ");
			lerTemperaturas.armazenamentoDosDados[indiceAno][indiceMes][k] = input.nextDouble();
			l++;
			
		}

	}
	
	//FAZER A MEDIA DA TEMPERATURAS MEDIAS
	public static double fazerMediaDasTemperaturas(Recursos mediaTemperatura, int indiceAnos, int indiceMeses, int qtdDDiasDoMes) {
		double somarTemperaturas=0;
		double l =1, q=1;
		
		for(int k =0; k < qtdDDiasDoMes; k++) {
			
			q++; // FAZER CONTAGEM PARA COMPARAR NO FINAL
			
			if (mediaTemperatura.armazenamentoDosDados[indiceAnos][indiceMeses][k] == 3.141592) {
				System.out.println("Voce inseriu um mes/ano em que nao possuimos registro. Experimente digitar a opcao 1 para armazenar os dados.");
				break;
			}
			
			somarTemperaturas = somarTemperaturas + mediaTemperatura.armazenamentoDosDados[indiceAnos][indiceMeses][k];
			
			l++; // FAZER CONTAGEM PARA COMPARAR NO FINAL
		}
		
		if(l != q) { return 3.141592; }
		
		double receberMediaPronta = somarTemperaturas / l;
		
		

		return receberMediaPronta;
	}
	
	//ARMAZENAR 3,141592 EM TODOS OS ESPACOS E PREDEFININDO JAN 2020
	public static void armazenarPiEmTudo (Recursos armazenarTudo) {

		
					
			for(int k = 0; k < 10; k++) {
				for(int p = 0; p < 12; p++) {
					for(int i = 0; i < 31; i++) {
						
						armazenarTudo.armazenamentoDosDados[k][p][i] = 3.141592;
						
					}
				}
			}
			
			armazenarTudo.armazenamentoDosDados[9][0][0] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][1] = 5;
			armazenarTudo.armazenamentoDosDados[9][0][2] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][3] = 5;
			armazenarTudo.armazenamentoDosDados[9][0][4] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][5] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][6] = 31;
			armazenarTudo.armazenamentoDosDados[9][0][7] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][8] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][9] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][10] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][11] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][12] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][13] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][14] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][15] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][16] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][17] = 5;
			armazenarTudo.armazenamentoDosDados[9][0][18] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][19] = 5;
			armazenarTudo.armazenamentoDosDados[9][0][20] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][21] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][22] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][23] = 31;
			armazenarTudo.armazenamentoDosDados[9][0][24] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][25] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][26] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][27] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][28] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][29] = 20;
			armazenarTudo.armazenamentoDosDados[9][0][30] = 31;
	}
	
	//PEGANDO E PRINTANDO TEMPERATURA MINIMA
	public static void acharTemperaturaMinima(Recursos acharTemperaturaMinima, int indiceAno, int indiceMes, int qtdDiaDoMes) {
		
		
		double compararMinimo = acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][0];
		
		int[] salvarDia = new int[31];
		
		int indiceDoVetor = 0;
		
		for(int h = 0; h < qtdDiaDoMes; h++) {
			
			if(h==0) { continue; }
			
			if(compararMinimo > acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h]) {
				
				compararMinimo = acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h];
			}
			
		}
		
		
		for(int h = 0; h < qtdDiaDoMes; h++) {
			
			if(compararMinimo == acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h]) {
				
				salvarDia[indiceDoVetor] = h + 1;
				
				indiceDoVetor++;
			}
			
			
		}
		
		//PRINTANDO MINIMA
		
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("               TEMPERATURA MINIMA               ");
		System.out.println("Temperatura minima reportada: "+compararMinimo+" °C");
		

			
		//PRINTANDO DIAS DE TEMP IGUAIS
		
		if(indiceDoVetor == 1 ) {
			
			System.out.println("Este mes nao possui temperaturas minimas repetidas.");
			voltarAoMenu();
			
			return;
		}
		
		System.out.print("Dias de temperaturas minimas iguais: ");
		for(int h = 0; h < indiceDoVetor; h++) {
			System.out.print(salvarDia[h]);	
			
			int salvarIndiceDoVetorParaArrumarVirgula = indiceDoVetor - 1;
			
			if(h < salvarIndiceDoVetorParaArrumarVirgula) {
				System.out.print(", ");
			} else {
				System.out.print(".");
			}
		}
		
		
		voltarAoMenu();
		
	}
	
	//PEGANDO E PRINTANDO TEMPERATURA MAXIMA
	public static void acharTemperaturaMaxima(Recursos acharTemperaturaMinima, int indiceAno, int indiceMes, int qtdDiaDoMes) {
		
		double compararMaximo = acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][0];
		
		int[] salvarDia = new int[31];
		
		int indiceDoVetor = 0;
		
		for(int h = 0; h < qtdDiaDoMes; h++) {
			
			if(h==0) { continue; }
			
			if(compararMaximo < acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h]) {
				
				compararMaximo = acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h];
			}
			
		}
		
		
		for(int h = 0; h < qtdDiaDoMes; h++) {
			
			if(compararMaximo == acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h]) {
				
				salvarDia[indiceDoVetor] = h + 1;
				
				indiceDoVetor++;
			}
			
			
		}
		
		//PRINTANDO MAXIMA
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("               TEMPERATURA MÁXIMA               ");
		System.out.println("Temperatura máxima reportada: "+compararMaximo+" °C");
		
		//PRINTANDO DIAS DE TEMP IGUAIS
		
		if(indiceDoVetor == 1 ) {
			System.out.println("Este mês não possui temperaturas máximas repetidas.");
			
			voltarAoMenu();
			
			return;
		}
		
		System.out.print("Dias de temperaturas iguais: ");
		for(int h = 0; h < indiceDoVetor; h++) {
			System.out.print(salvarDia[h]);		
			
			int salvarIndiceDoVetorParaArrumarVirgula = indiceDoVetor - 1;
			
			if(h < salvarIndiceDoVetorParaArrumarVirgula) {
				System.out.print(", ");
			} else {
				System.out.print(".");
			}
		}
		
		
		voltarAoMenu();
		
	}

	//RELATORIO METERIOLOGICO
	public static void relatorioMeteriologico(Recursos printandoORelatorio, int indiceAno, int indiceMes, int qtdDiaDoMes) {
	
		int salvarDia = 0;
		
		//PRINTAR AS TEMPERATURAS DOS DIAS
		System.out.println("------------------------------------------");
		System.out.println("TEMPERATURA MEDIA DE TODOS OS DIAS DO MES");
		System.out.println();
	
		for(int h= 0; h < qtdDiaDoMes; h++) {
			
			salvarDia++;
			System.out.println("Dia "+salvarDia+": "+printandoORelatorio.armazenamentoDosDados[indiceAno][indiceMes][h]+" °C");
			
		}
		
		//PRINTAR A MEDIA DE TEMPERATURA
		double media;
		media = fazerMediaDasTemperaturas(printandoORelatorio, indiceAno, indiceMes, qtdDiaDoMes);
		
		System.out.println();
		System.out.println("TEMPERATURA MEDIA, MINIMA E MAXIMA");
		System.out.println();
		System.out.print("Media: "+media+" °C");
		System.out.println();
		
		//PRINTAR A TEMPERATURA MINIMA DO MES
		retornarTemperaturaMinima(printandoORelatorio, indiceAno, indiceMes, qtdDiaDoMes);
		
		//PRINTA A TEMPERATURA MAX DO MES
		retornarTemperaturaMaxima(printandoORelatorio, indiceAno, indiceMes, qtdDiaDoMes);
		
		System.out.println("------------------------------------------");
		voltarAoMenu();
		
	}
	
	//VOLTAR AO MENU DE OPÇÕES
	public static void voltarAoMenu() {
		
		Scanner input = new Scanner(System.in);
		String digiteMenu;
		
		System.out.println();
		System.out.println();
		System.out.print("*Digite "+"'menu'"+" para voltar ao menu de opcoes: ");
		digiteMenu = input.next();
		
		while(!digiteMenu.equalsIgnoreCase("Menu")) {
			
			System.out.print("*Digite "+"menu"+" para voltar ao menu de opcoes: ");
			digiteMenu = input.next();
		}
	}

	//TEMPERATURA MININMA SALVAR NUMA VARIAVEL E RETORNAR
	public static void retornarTemperaturaMinima(Recursos acharTemperaturaMinima, int indiceAno, int indiceMes, int qtdDiaDoMes) {
		
double compararMinimo = acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][0];
						
		for(int h = 0; h < qtdDiaDoMes; h++) {
			
			if(h==0) { continue; }
			
			if(compararMinimo > acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h]) {
				
				compararMinimo = acharTemperaturaMinima.armazenamentoDosDados[indiceAno][indiceMes][h];
			}
			
		}	
		
		System.out.print("Temperatura minima do mes: "+compararMinimo+" °C");
		System.out.println();
	}

	//TEMPERATURA MAXIMA SALVAR NUMA VARIAVEL E RETORNAR
	public static void retornarTemperaturaMaxima(Recursos acharTemperaturaMaxima, int indiceAno, int indiceMes, int qtdDiaDoMes) {
		
		
double compararMaximo = acharTemperaturaMaxima.armazenamentoDosDados[indiceAno][indiceMes][0];
						
		for(int h = 0; h < qtdDiaDoMes; h++) {
			
			if(h==0) { continue; }
			
			if(compararMaximo < acharTemperaturaMaxima.armazenamentoDosDados[indiceAno][indiceMes][h]) {
				
				compararMaximo = acharTemperaturaMaxima.armazenamentoDosDados[indiceAno][indiceMes][h];
			}
			
		}	
		
		System.out.print("Temperatura maxima do mes: "+compararMaximo+" °C");
		System.out.println();
	}

	//VERIFICAR SE O DADO FOI SALVO
	public static int verificacaoDosDados(Recursos verificarDados, int indiceAno, int indiceMes, int qtdDiaDoMes) {
		
		for(int h = 0; h < qtdDiaDoMes; h++) {
			if( verificarDados.armazenamentoDosDados[indiceAno][indiceMes][h] == 3.141592) {
				System.out.println();
				System.out.println("*Voce ainda nao armazenou dados nesse mes/ano.");
				return 1;
			}
		}
		
		return 0;
	}

}//FIM DO COD