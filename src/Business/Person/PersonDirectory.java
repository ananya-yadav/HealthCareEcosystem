/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class PersonDirectory {
    private ArrayList<Person> personDirectory;

    public PersonDirectory() {
        personDirectory=new ArrayList<>();
    }
    

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public Person addPerson(String name){
        Person person=new Person();
        person.setName(name);
        personDirectory.add(person);
        return person;
    }
    
    public void removePerson(String name){
        int i=0;
        for(Person p : personDirectory){
            if(p.getName().equals(name)){
                break;
            }
            i++;
        }
        personDirectory.remove(i);
    }
    
    
    
}
