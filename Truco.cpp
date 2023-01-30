
#include <iostream>
using namespace std;

class Jogador{
    public:
    int cards[3];
};

class Computador{
    public:
    int cards[3];
};

class Cartas{
    public:
    int manilha1, manilha2, manilha3, manilha4;
    int vira;
    int cards[40] = {
    "3P";"3C";"3E";"3O";"2P";"2C";"2E";"2O";
    "1P";"1C";"1E";"1O";"KP";"KC";"KE";"KO";
    "JP";"JC";"JE";"JO";"QP";"QC";"QE";"QO";
    "7P";"7C";"7E";"7O";"6P";"6C";"6E";"6O";
    "5P";"5C";"5E";"5O";"4P";"4C";"4E";"4O";};
    int values[40] = {};
    void monte();
};

void Cartas::monte(){
    int monte0[40] = {};
    for(int i=0;i<40;i++){
    values[i] = 40-i;}
    for(int i=0;i<40;i++){
    monte0[i] = cards[i];}
    auto seed = unsigned(std::time(0));
    std::srand (seed);
    std::random_shuffle(cards.begin(), cards.end());
    std::srand (seed);
    std::random_shuffle(values.begin(), values.end());
    vira = 40-values[0];
    int t = ((vira-4)/4)*4;
    manilha1,manilha2,manilha3,manilha4 = 
    cards[t], cards[t+1],cards[t+2],cards[t+3];
}

int main(){
    return 0;
}