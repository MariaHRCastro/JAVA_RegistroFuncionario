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
		
		System.out.print("Quantos empregados ser�o registrados? ");
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
			System.out.println();
			System.out.println("Funcion�rio #" + (i+1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Sal�rio: ");
			double salario = sc.nextDouble();
			
			Funcionario funcionario = new Funcionario(id,nome,salario);
			
			list.add(funcionario);
			
		}
		
		System.out.println();
		System.out.print("Digite o Id do funcion�rio que ter� o sal�rio aumentado:");
		int idaumento = sc.nextInt();
		
		Integer posicao = posicao(list,idaumento);
		if (posicao == null) {
			System.out.println("Esse Id n�o existe!");
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
		for (int i = 0; /*I VAI NUM VALOR FIXO, QUE � O COMPRIMENTO DA LISTA*/ i < list.size();i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		
		return null;
	}
	
}
