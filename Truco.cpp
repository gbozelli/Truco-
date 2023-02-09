
#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>
#include <vector>
using namespace std;

class Cartas{
    public:
    int valor;
    string carta;
};

class Card_Owner{
    public:
    int k = 10;
    Cartas* cards = new Cartas[k];
    void card_transfer(int quantity, Card_Owner destin);
};

class Base_Player: public Card_Owner{
    public:
    Base_Player(){
        k = 3;
    }
    int pontuation = 0;
    int number_of_cards = 3;
    public:
    void play();
};

class Human_Player : public Base_Player{
    public:
    void play();
};

class Robot_Player : public Base_Player{
    public:
    void play();
};

class Monte : public Card_Owner{
    public:
    Monte(){
        k = 40;
    }
    string cartas[40] = {
    "3P","3C","3E","3O","2P","2C","2E","2O",
    "1P","1C","1E","1O","KP","KC","KE","KO",
    "JP","JC","JE","JO","QP","QC","QE","QO",
    "7P","7C","7E","7O","6P","6C","6E","6O",
    "5P","5C","5E","5O","4P","4C","4E","4O"};
    Cartas ordemjogo[12];
    void maço();
    int a = 1;
    void card_transfer(Human_Player destino, int a);
    void card_transfer(Robot_Player destino, int a);
    void monta(Human_Player A1, Robot_Player A2, Robot_Player B1, Robot_Player B2);
    void Mesa();
};

class Mesa : public Card_Owner{
    public:
    Mesa(){
        k = 12;
    }
};

void Monte::maço(){
    for(int i = 0;i<40;i++){
        cards[i].carta = cartas[i];
        cards[i].valor = 40-i;}
    int r = (((0 + (rand() % 40))-4)/4)*4;
    for (int i = r; i < 40; i++){
        cards[i] = cards[i + 1];}
    for(int i=r;i<r+3;i++){
        cards[i].valor = cards[i].valor + 41;
}}

void Card_Owner::card_transfer(int quantity, Card_Owner destino){
    for(int i = 0;i<3;i++){
        int r = i + (rand() % 40-i);
        destino.cards[i] = cards[r];
        for (int i = i; i < 40-i; ++i){
            cards[i] = cards[i + 1];
}}}

void Monte::monta(Human_Player A1, Robot_Player A2, Robot_Player B1, Robot_Player B2){
    maço();
    card_transfer(A1, 1);
    card_transfer(A2, 4);
    card_transfer(B1, 7);
    card_transfer(B2, 10);
}

void Human_Player::play(){
    for(int i=0;i<number_of_cards;i++){
    cout<<i<<" - " << cards[i].carta<<" ";}
    cout<<"Qual deseja jogar?";
    int a; cin>> a;
    cout<<"Você jogou "<<cards[a].carta;
    for (int i = 0; i <number_of_cards; ++i){
        cards[i] = cards[i + 1];}
    number_of_cards--;
}

void Robot_Player::play(){
    int i = 0;
    if(number_of_cards==3){
        i = i + (rand() % 2);
        cout <<"O Robot_Player jogou "<<cards[i].carta;}
    if(number_of_cards==2){
        i = 0;
        cout <<"O Robot_Player jogou "<<cards[i].carta;}
    for (int i = 0; i <number_of_cards; ++i){
        cards[i] = cards[i + 1];}
    number_of_cards--;
}

int main(){
    Human_Player A1;
    Robot_Player A2;
    Robot_Player B1;
    Robot_Player B2;
    Monte monte;
    monte.monta(A1,A2,B1,B2);
    return 0;
}