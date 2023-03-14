class jooj{
    public static void main(String[] args){
        B B = new B();
        M M = new M(B);
        M.A.l(3);
    }
}

class A{
    int l = 2;
    public void l(){
        this.l = 3;
    }
}

class B extends A{
    int l = 3;
    public void l(int v){
        this.l = v;
    }
}

class M{
    A A;
    M(A A){
        this.A = A;
    }
    public void set(B B){
        M M = new M(B);
    }
}