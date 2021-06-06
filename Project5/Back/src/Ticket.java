public class Ticket {
    Museum museum;
    int noAdult;
    int noSenior;
    int noStudent;

    public Ticket(Museum museum, int noAdult, int noStudent, int noSenior){
        this.museum = museum;
        this.noAdult = noAdult;
        this.noStudent = noStudent;
        this.noSenior = noSenior;
    }

    public int getNoAdult() {
        return noAdult;
    }
    public int getNoSenior(){
        return noSenior;
    }
    public int getNoStudent(){
        return noStudent;
    }

    public boolean addAdult(){
        if(noAdult>=5){
            return false;
        }
        else{
            noAdult+=1;
            return true;
        }
    }

    public boolean addSenior(){
        if(noSenior >=5){
            return false;
        }
        else{
            noSenior +=1;
            return true;
        }
    }

    public boolean addStudent(){
        if(noStudent>=5){
            return false;
        }
        else{
            noStudent+=1;
            return true;
        }
    }


    //depends on the museum have to change this
    public double getTotalPrice(){
        if(museum instanceof Met){
            Met met = (Met)museum;
            return noAdult*met.getPriceAdult()+noStudent*met.getPriceStudent()+ noSenior * met.getPriceSenior();
        }
        else if(museum instanceof Moma){
            Moma moma = (Moma)museum;
            return noAdult*moma.getPriceAdult()+noStudent*moma.getPriceStudent()+ noSenior * moma.getPriceSenior();
        }
        else if(museum instanceof Guggenheim){
            Guggenheim guggenheim = (Guggenheim)museum;
            return noAdult*guggenheim.getPriceAdult()+noStudent*guggenheim.getPriceStudent()+ noSenior * guggenheim.getPriceSenior();
        }
        else if(museum instanceof History){
            History history = (History) museum;
            return noAdult*history.getPriceAdult()+noStudent*history.getPriceStudent()+ noSenior * history.getPriceSenior();
        }
        else {
            return 0;
        }
    }

    public double getSalestax(){
        double totalPrice = getTotalPrice();
        return 1.0875*totalPrice;
    }

    public static void main(String args[]){
        System.out.println("Begin");
        Ticket ti = new Ticket(new Met(), 0, 0, 0);
        ti.addAdult();
        ti.addSenior();
        ti.addStudent();
        System.out.println(ti.getTotalPrice());
    }
}
