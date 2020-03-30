package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String qrgs[]) {
	
	//Set<String> zbiorDni = new HashSet<>();
	Set<String> zbiorDni = new TreeSet<>();
	zbiorDni.add("poniedziałek");
	zbiorDni.add("wtorek");
	zbiorDni.add("środa");
	zbiorDni.add("czwartek");
	zbiorDni.add("piątek");
	zbiorDni.add("sobota");
	zbiorDni.add("niedziela");
	
	//for(String dzien : zbiorDni) {
	//    System.out.println(dzien);
	//}
	
	//PYT. 1
	//Hashset jest nieuporządkowaną strukturą. Nie wiemy w jakiej kolejności wypisane zostaną elementy.
	//Treeset zwraca nam uporządkowane elementy
	
	//PYT. 2
	//Hashset używamy jeśli kolejność dodawanych elementów nie ma znaczenia
	//Treeset używamy jeśli chcemy iterować po posortowanym zbiorze
	
	//PYT. 3
	//Oprócz implementacji klasy nie była wymagana ingerencja w kod.
	
	Map<String, Teacher> prowadzacy = new HashMap<>();
	
	prowadzacy.put("Programowanie obiektowe",new Teacher("Michał","Fedorov","mfedorov@wi.zut.edu.pl","Programowanie obiektowe"));
	prowadzacy.put("Systemy operacyjne II",new Teacher("Witold","Maćkow","wmackow@wi.zut.edu.pl","Systemy operacyjne II"));
	prowadzacy.put("Projektowanie aplikacji internetowych",new Teacher("Maciej","Roszkowski","mroszkowski@wi.zut.edu.pl","Projektowanie aplikacji internetowych"));
	prowadzacy.put("Projekt zespołowy",new Teacher("Luiza","Fabisiak","lfabisiak@wi.zut.edu.pl","Projekt zespo�owy"));
	
	Person nauczyciel_po = prowadzacy.get("Programowanie obiektowe");
	System.out.println("Prowadzącym kurs programowanie obiektowe jest: " + nauczyciel_po);
	
	List<Student> studenci1 = new ArrayList<>();
	studenci1.add(new Student("Jan","Kowalski","kj1234@zut.edu.pl","32A"));
	studenci1.add(new Student("Anna","Nowak","na1234@zut.edu.pl","32A"));
	studenci1.add(new Student("Tomasz","Krzak","kt1234@zut.edu.pl","32A"));
	studenci1.add(new Student("Adam","Ptak","pa1234@zut.edu.pl","32A"));
	studenci1.add(new Student("Grzegorz","Nowakowski","ng1234@zut.edu.pl","32A"));
	
	List<Student> studenci2 = new ArrayList<>();
	studenci2.add(new Student("Piotr","Kowalczyk","kp1234@zut.edu.pl","31A"));
	studenci2.add(new Student("Barbara","Koralewska","kb1234@zut.edu.pl","31A"));
	studenci2.add(new Student("Jakub","Prosty","pj1234@zut.edu.pl","31A"));
	studenci2.add(new Student("Piotr","Krzywy","kj1234@zut.edu.pl","31A"));
	studenci2.add(new Student("Wiktoria","Niezbędna","nw1234@zut.edu.pl","31A"));
	
	List<Student> studenci3 = new ArrayList<>();
	studenci3.add(new Student("Adrianna","Węgiel","wa1234@zut.edu.pl","33A"));
	studenci3.add(new Student("Paweł","Borys","bp1234@zut.edu.pl","33A"));
	studenci3.add(new Student("Tomasz","Zaradny","zt1234@zut.edu.pl","33A"));
	studenci3.add(new Student("Krzysztof","Żarówka","zk1234@zut.edu.pl","33A"));
	studenci3.add(new Student("Michał","Niesamowity","nm1234@zut.edu.pl","33A"));
	
	Map<String, List<Student>> grupy = new HashMap<>();
	
	grupy.put("32A", studenci1);
	grupy.put("31A", studenci2);
	grupy.put("33A", studenci3);
	
	List<Student> studenci = grupy.get("32A");
	
	for(Student student : studenci) {
	    System.out.println(student);
	}
	
	List<Product> produkty = new ArrayList<>();
	Map<Integer, Product> produkt_id = new HashMap<>();
	
	Map<String,List<Product>> produkt_kat = new HashMap<>();
	
	try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

	    String s = in.readLine();

	    while(s!=null) {
	    	String[] pola = s.split(";");
	    	Product produkt = new Product(Integer.parseInt(pola[0]),pola[1],pola[2],Double.parseDouble(pola[3]));
	        produkty.add(produkt);
	        
	        produkt_id.put(produkt.id,produkt);
	        
	        if(produkt_kat.containsKey(produkt.category)) {
				List<Product> lista = produkt_kat.get(produkt.category);
				lista.add(produkt);
			}else {
				List<Product> lista = new ArrayList<>();
				lista.add(produkt);
				produkt_kat.put(produkt.category, lista);
			}
	        
	        s = in.readLine();
	        
	    }
	} catch (IOException ex) {
	    ex.printStackTrace();
	}	
	
	Product po_id = produkt_id.get(102);
	System.out.println("Produkt o ID 102: " + po_id);
	
	List<Product> produkty_narz = produkt_kat.get("narzędzia");
	System.out.println("Produkty z kategorii NARZĘDZIA: ");
	
	for(Product produkt : produkty_narz) {
		System.out.println(produkt);
	}
	
	}
}
