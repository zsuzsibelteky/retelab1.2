package hu.bme.mit.yakindu.analysis.workhere;

import java.io.IOException;
import java.io.InputStream;

import hu.bme.mit.yakindu.analysis.RuntimeService;
import hu.bme.mit.yakindu.analysis.TimerService;
import hu.bme.mit.yakindu.analysis.example.ExampleStatemachine;
import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;

import java.util.Scanner;


public class RunStatechart {
	
	public static void main(String[] args) throws IOException {
		ExampleStatemachine s = new ExampleStatemachine();
		s.setTimer(new TimerService());
		RuntimeService.getInstance().registerStatemachine(s, 200);
		s.init();
		s.enter();
		
		Scanner input = new Scanner(System.in);
		String order;
		while (true) {
			order = input.nextLine();
			if (order.equals("start"))
			{
				s.raiseStart();
				s.runCycle();
				print(s);
			} 
			else if (order.equals("white"))
			{
				s.raiseWhite();
				s.runCycle();
				print(s);
			} 
			else if (order.equals("black"))
			{
				s.raiseBlack();
				s.runCycle();
				print(s);
			}
			else if (order.equals("exit"))
			{
				System.exit(0);
			}
			else if (!order.isEmpty()){
				System.out.println("Wrong order! Try start/white/black/exit.");
			}
		}
	}

	public static void print(IExampleStatemachine s) {
		System.out.println("W = " + s.getSCInterface().getWhiteTime());
		System.out.println("B = " + s.getSCInterface().getBlackTime());
	}
}
