
import java.util.Random;

class truco{
    public static void main(String[] args){
        System.out.println("saas");
    }
}

class cards{
    int value;
    String card;
    String signature;
}

class player implements card_manager{
    int len;
    int limit = len;
    public void transfer_cards(card_manager destiny, int quantity){
        for(int i=0;i<quantity;i++){destiny.cards[i]=this.cards[i];delete(this.cards,i);this.limit--;}
    }
    public void delete(cards[] cards, int position){
        swap(cards, position);
    }
    public void swap(cards[] cards, int position){
        cards key = cards[len];
        cards[len] = cards[position];
        cards[position] = key; 
    }
    public void sort(){
        int current_number;
        for(int i=1; i<this.limit; i++){
            current_number = this.cards[i].value;
            int j = i-1;
            while(this.cards[j].value>current_number & j>=0){
                this.cards[j+1].value = this.cards[j].value;
                j = j-1;
        }
            this.cards[j+1].value = current_number;}}
    public void ordenate(){
        cards main_card = this.cards[13];
        int seq = (main_card.value/4)*4;
        for(seq=seq;seq<seq+4;seq++){
            this.cards[seq].value += 40;
        }
        sort();
    }
    public void special_card(player p, cards[] card,int i){
        p.cards[p.limit] = cards[i];
        p.limit++;
    }
    public void play(){}
}

class Node {
    player A1;
    Node next;
    Node prev;
    public Node(player A1){
        this.A1 = A1;
    }
    public static Node list(player A1,player A2, player B1, player B2){
        Node a1 = new Node(A1); Node a2 = new Node(A2); Node b1 = new Node(B1); Node b2 = new Node(B2);
        a1.next = b1;b1.next=a2;a2.next=b2;b2.next=a1;
        a1.prev = b2;b2.prev=a2;a2.prev=b1;b1.prev=a1;
        Node sub = a1;
        return sub;
    }
}

class Human extends player{
    int len = 3;
    cards[] cards = new cards[len];
    public void play(){};
}

class Deck extends player{
    int len = 40;
    cards[] cards = new cards[len];
    int limit = len;
    player A1,A2,A3,A4;
    Mesa mesa;
    Deck(player A1, player A2, player B1, player B2,Mesa mesa){
        create_deck(A1,A2,A3,A4,mesa);
    }
    public void create_deck(player A1, player A2, player B1, player B2, Mesa mesa){
        String[] card_name = {"4O","4E","4C","4P",
        "5O","5E","5C","5P","6O","6E","6C","6P",
        "7O","7E","7C","7P","QO","QE","QC","QP",
        "JO","JE","JC","JP","KO","KE","KC","KP",
        "1O","1E","1C","1P","2O","2E","2C","2P",
        "3O","3E","3C","3P",};
        for(int i=0;i<len;i++){
            this.cards[i].value = i;
            this.cards[i].card = card_name[i];}
        Random rand = new Random();
        int r = rand.nextInt(1);
        cards main_card = this.cards[r];
        special_card(mesa, this.cards, r);
        delete(this.cards, r);this.limit--;
        int add=1;
        for(int i=((main_card.value/4)*4)+4;i<((main_card.value/4)*4)+8;i++){
            add++;
            this.cards[i].value = 40+add;}
        for(int i=0;i<limit;i++){
            r = rand.nextInt(i);
            swap(this.cards, r);}
        transfer_cards(A1, 3);
        transfer_cards(A2, 3);
        transfer_cards(B1, 3);
        transfer_cards(B2, 3);
        }      
}

class Mesa extends player{
    int len = 4;
    cards[] cards = new cards[len];
    int limit = 0;
    int points_counter=12;
    cards key_card;
    public void key_card(){
        key_card = cards[1];
        cards = new cards[len];
    }
}



class Robot extends player{
    public void play(Mesa Mesa){
        sort(); 
        int i;
        double control = 0;
        for(i=0;i<this.limit;i++){
            control += this.cards[i].value;
        }
        control /= this.limit;
        if(this.limit==3){
        if(control>30){special_card(Mesa, this.cards, 1);}
        if(control>20){special_card(Mesa, this.cards, 0);}}
        if(this.limit==2){
        if(control>20){special_card(Mesa, this.cards, 0);}
        if(control>0){special_card(Mesa, this.cards, 1);}}
        if(this.limit==2){special_card(Mesa, this.cards, 0);}
    }
}

class Group{
    int pontuation = 0;
    String signature;
    player A1;
    player A2;
    Group(player A1,player A2, String signature){
        this.A1 = A1;
        this.A2 = A2;
        for(int i=0;i<A1.len;i++){
            A1.cards[i].signature = signature;
            A1.cards[i].signature = signature;
        }
    }
}

class Game{
    Mesa mesa = new Mesa();
    Human A1; Robot A2, B1, B2;
    Deck deck = new Deck(A1,A2,B1,B2,mesa);
    Group A = new Group(A1,A2,"A");
    Group B = new Group(B1,B2,"B");
    Node seq = Node.list(A1,A2,B1,B2);
    Game(){
        
    }
    public void sub_round(){
        this.mesa.key_card();
        for(seq = this.seq.next;seq!=this.seq;seq = this.seq.next){
            seq.A1.play();
        }
        this.mesa.sort();
        if(this.mesa.cards[0].signature == "A"){
            this.A.pontuation++;
        }else{
            this.B.pontuation++;
        }
    }
    public void round(){
        while(this.A.pontuation!=12 && this.B.pontuation!=12){
            sub_round();
        }
    }

}