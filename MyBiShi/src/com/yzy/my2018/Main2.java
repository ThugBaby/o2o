package com.yzy.my2018;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Main2 {

	
	static class Position{
		int x=0;
		int y=0;
		public Position(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] temp = sc.nextLine().split(",");
		int sx=Integer.valueOf(temp[0]);
		int sy=Integer.valueOf(temp[1]);
		
		temp=sc.nextLine().split(",");
		int i=0;
		List<Position> ls=new ArrayList<Position>();
		int maxX=0;
		int maxY=0;
		while(i<temp.length-1)
		{
			new Position(Integer.valueOf(temp[i]),Integer.valueOf(temp[i+1]));
			i=i+2;
			maxX=Math.max(maxX,Integer.valueOf(temp[i]));
			maxY=Math.max(maxY,Integer.valueOf(temp[i]));
		}
		Position center=new Position(0,0);
		Iterator<Position> it=ls.iterator();
		double pre=0;
		double cur=0;
		for(int x=0;x<=maxX;x++)
			for(int y=0;y<maxY;y++)
			{
				while(it.hasNext())
				{
					if(pre==0)
					{
						pre=Math.sqrt(Math.pow(x-it.next().x,2)-Math.pow(y-it.next().y,2));
						cur=pre;
					}
					cur=Math.sqrt(Math.pow(x-it.next().x,2)-Math.pow(y-it.next().y,2));
					if(pre!=cur)
						break;
					pre=cur;
					center.x=x;
					center.y=y;
				}
			}
		double sdist=cur;
		double tdist=Math.sqrt(Math.pow(center.x-sx,2)-Math.pow(center.y-sy,2));
		if(tdist>sdist)
		{
			//不在范围内
			System.out.println("小广应该走的距离为:"+(tdist-sdist));
		}
		System.out.println("yes");
		System.out.println();
	}
}
