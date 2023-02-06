
#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>
using namespace std;

class Cartas{
    public:
    int valor;
    string carta;
};

class Jogador{
    public:
    Cartas cards[3];
};

class Computador{
    public:
    Cartas cards[3];
};

class Monte{
    public:
    Cartas cards[40];
    string cartas[40] = {
    "3P","3C","3E","3O","2P","2C","2E","2O",
    "1P","1C","1E","1O","KP","KC","KE","KO",
    "JP","JC","JE","JO","QP","QC","QE","QO",
    "7P","7C","7E","7O","6P","6C","6E","6O",
    "5P","5C","5E","5O","4P","4C","4E","4O"};
    Cartas ordemjogo[12];
    void maço();
    int a = 1;
    void transfere(Jogador destino, int a);
    void transfere(Computador destino, int a);
    void ordem();
    void monta(Jogador A1, Computador A2, Computador B1, Computador B2);
};

class Rodada{
    Monte monte;
    monte; 
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
    }
}

void Monte::transfere(Jogador destino, int a){
    for(int i = 0;i<3;i++){
        int r = i + (rand() % 40-i-a);
        destino.cards[i] = cards[r];
        ordemjogo[i] = cards[r];
        for (int i = i; i < 40-i-a; ++i){
            cards[i] = cards[i + 1];
        }
    }
}

void Monte::monta(Jogador A1, Computador A2, Computador B1, Computador B2){
    maço();
    transfere(A1, 1);
    transfere(A2, 4);
    transfere(B1, 7);
    transfere(B2, 10);
}


int main(){
    return 0;
}