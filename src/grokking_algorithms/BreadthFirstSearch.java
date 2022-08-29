package grokking_algorithms;

import java.util.*;


public class BreadthFirstSearch {
    public static void main(String[] args) {
        Person you = new Person("you", false);
        Person alice = new Person("alice", false);
        Person bob = new Person("bob", false);
        Person claire = new Person("claire", false);
        Person anuj = new Person("anuj", false);
        Person peggy = new Person("peggy", false);
        Person thom = new Person("thom", true);
        Person jonny = new Person("jonny", false);

        HashMap<Person, ArrayList<Person>> graph = new HashMap<>();
        graph.put(you, new ArrayList<>(Arrays.asList(alice, bob, claire)));
        graph.put(bob, new ArrayList<>(Arrays.asList(anuj, peggy)));
        graph.put(alice, new ArrayList<>(Arrays.asList(peggy)));
        graph.put(claire, new ArrayList<>(Arrays.asList(thom, jonny)));
        graph.put(anuj, new ArrayList<>());
        graph.put(peggy, new ArrayList<>());
        graph.put(thom, new ArrayList<>());
        graph.put(jonny, new ArrayList<>());

        breadthFirstSearch(graph, you);
    }

    public static void breadthFirstSearch(HashMap<Person, ArrayList<Person>> graph, Person you) {
        ArrayDeque<Person> searchQueue = new ArrayDeque<>(graph.get(you));
        ArrayList<Person> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()) {
            Person person = searchQueue.pop();
            if (!searched.contains(person)) {
                if (person.isMangoSeller()) {
                    System.out.println(person.getName() + " is a mango seller");
                    return;
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        System.out.println("there is no mango sellers");
    }

    private static class Person {
        private final String name;
        private final boolean isMangoSeller;

        public Person(String name, boolean isMangoSeller) {
            this.name = name;
            this.isMangoSeller = isMangoSeller;
        }

        public String getName() {
            return name;
        }

        public boolean isMangoSeller() {
            return isMangoSeller;
        }
    }
}
