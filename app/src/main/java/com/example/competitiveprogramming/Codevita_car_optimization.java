import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Codevita_car_optimization {
	static HashMap<Integer, ArrayList<Car>>hashMap=new HashMap<Integer, ArrayList<Car>>();
	static int cost=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfCars=sc.nextInt();
		int priority[];
		Set<Integer> set=new HashSet<>();
		int largeSlots=sc.nextInt();
		int mediumSlots=sc.nextInt();
		int smallSlots=sc.nextInt();
		int smal[]=new int[24];
		int med[]=new int[24];
		int large[]=new int[24];
		for(int i=0;i<noOfCars;i++){
			int carNo=sc.nextInt();
			String size=sc.next();
			int arrival=sc.nextInt();
			int departure=sc.nextInt();
			Car car=new Car(carNo,size,arrival,departure);
			set.add(car.duration);
			if(hashMap.get(car.duration)==null){
				hashMap.put(car.duration,new ArrayList<Car>());
			}
			hashMap.get(car.duration).add(car);
		}
		priority=new int[set.size()];
		Object objects[]=set.toArray();
		for(int i=0;i<priority.length;i++){
			priority[i]=(Integer)objects[i];
		}
		Arrays.sort(priority);
		for(int i=0;i<=(priority.length-1);i++){
//			System.out.println();
//			System.out.println();System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("----------------");System.out.println();



			for(int j=0;j<hashMap.get(priority[i]).size();j++){
				Car car=hashMap.get(priority[i]).get(j);
				//System.out.println("Searching slot for car no:"+car.carNo);
				boolean slotFound=false;
				switch (car.size){
					case "small":
						searchSmall: for(int k=car.arrival;k<car.departure;k++){
							if(smal[k]==smallSlots){
								slotFound=false;
//								System.out.println("Small completely occupied");
								break searchSmall;
							}
							else
								slotFound=true;
						}
						if(slotFound){
							for(int k=car.arrival;k<car.departure;k++){
								smal[k]++;
							}
//							System.out.println("Smallslot allocated!");
							cost+=(50*car.duration);
							break;
						}

					case "medium":
						searchMed: for(int k=car.arrival;k<car.departure;k++){
							if(med[k]==mediumSlots){
								slotFound=false;
//								System.out.println("Medium completely occupied");
								break searchMed;
							}
							else
								slotFound=true;
						}
						if(slotFound){
							for(int k=car.arrival;k<car.departure;k++){
								med[k]++;
							}
//							System.out.println("Medium slot allocated!");
							cost+=(75*car.duration);
							break;
						}

					case "large":
						searchLarge: for(int k=car.arrival;k<car.departure;k++){
							if(large[k]==largeSlots){
								slotFound=false;
//								System.out.println("Large completely occupied");
								break searchLarge;
							}
							else
								slotFound=true;
						}
						if(slotFound){
							for(int k=car.arrival;k<car.departure;k++){
								large[k]++;
							}
//							System.out.println("Large slot allocated!");
							cost+=(100*car.duration);
							break;
						}
				}

				//System.out.println();
			}
		}
//		Arrays.stream(smal).forEach(e-> System.out.print(e+" "));
//		System.out.println();
//		Arrays.stream(med).forEach(e-> System.out.print(e+" "));
//		System.out.println();
//		Arrays.stream(large).forEach(e-> System.out.print(e+" "));
//		System.out.println();
		System.out.println(cost);
	}
	static class Car{
		int carNo;
		String size;
		int arrival;
		int departure;
		int duration;

		public Car(int carNo, String size, int arrival, int departure) {
			this.carNo = carNo;
			this.size = size;
			this.arrival = arrival;
			this.departure = departure;
			if(departure<arrival){
				duration=24+departure-arrival;
			}else{
				duration=departure-arrival;
			}
		}
	}
}
/*
* 10
3 3 3
1 small 20 21
2 small 20 21
3 small 20 21
4 medium 20 21
5 medium 20 21
6 medium 20 21
10 small 20 21
7 large 20 21
8 large 20 21
9 large 20 21
* */
/*
* 8
3 3 3
1 medium 18 20
2 medium 19 20
3 medium 18 21
4 large 20 21
5 medium 18 19
6 medium 18 19
7 medium 18 19
8 medium 18 19*/