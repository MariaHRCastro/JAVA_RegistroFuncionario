package Aplicativo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidade.Funcionario;

public class Registro {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		List <Funcionario> list = new ArrayList<>();
		
		System.out.print("Quantos empregados serão registrados? ");
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
			System.out.println();
			System.out.println("Funcionário #" + (i+1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			
			Funcionario funcionario = new Funcionario(id,nome,salario);
			
			list.add(funcionario);
			
		}
		
		System.out.println();
		System.out.print("Digite o Id do funcionário que terá o salário aumentado:");
		int idaumento = sc.nextInt();
		
		Integer posicao = posicao(list,idaumento);
		if (posicao == null) {
			System.out.println("Esse Id não existe!");
		}else {
			System.out.print("Qual a porcentagem do aumento? ");
			double porcentagem = sc.nextDouble();
			list.get(posicao).aumentoSalario(porcentagem);
		}
		
		
		System.out.println();
		System.out.println("Lista de empregados:");
		for (Funcionario funcionario : list) {
			System.out.println(funcionario);
		}
		
		
		
		
		sc.close();
		
	}

	public static Integer posicao (/*Declaro a lista*/ List <Funcionario> list,int id) {
		for (int i = 0; /*I VAI NUM VALOR FIXO, QUE É O COMPRIMENTO DA LISTA*/ i < list.size();i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		
		return null;
	}
	
}
