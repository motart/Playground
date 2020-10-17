package keeper;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        Person kishore = new Person("kishore");
        Person ibrahim = new Person("ibrahim");
        Person marc = new Person("marc");
        Person nick = new Person("nick");
        Person cheng = new Person("cheng");

        Person[] kishoreFriends = { ibrahim, marc };
        kishore.setFriends(kishoreFriends);

        Person[] ibrahimFriends = { marc, nick };
        ibrahim.setFriends(ibrahimFriends);

        Person[] marcFriends = { kishore, nick, cheng };
        marc.setFriends(marcFriends);

        Person[] nickFriends = { marc, ibrahim };
        nick.setFriends(nickFriends);

        Person[] chengFriends = { ibrahim };
        cheng.setFriends(chengFriends);

        findAllFriendsForPerson(ibrahim);
    }

    public static void findAllFriendsForPerson(Person person) {
        List<Person> result = new ArrayList<Person>();
        getFriends(person, result, person);
        System.out.println(result);
    }

    public static void getFriends(Person person, List<Person> visited, Person root) {
        for (Person friend : person.getFriends()) {
            if (!visited.contains(friend) && !friend.equals(root)) {
                visited.add(friend);
                getFriends(friend,visited, root);
            }
        }
    }
}

class Person {
    private Person[] friends;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person[] getFriends() {
        return this.friends;
    }

    public String getName() {
        return this.name;
    }

    public boolean isFriendWith(Person person) {
        for (Person p : this.friends) {
            if (p != null && person != null && p.getName().equals(person.getName()))
                return true;
        }

        return false;
    }

    public boolean equals(Person person) {
        return this.name.equals(person.getName());
    }

    public String toString() {
        return this.getName();
    }

    public void setFriends(final Person[] friends) {
        this.friends = friends;
    }

}