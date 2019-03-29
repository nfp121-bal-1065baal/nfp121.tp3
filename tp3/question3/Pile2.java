package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        // à compléter
        if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        // à compléter
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        // à compléter
        if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        // à compléter
         if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        // à compléter
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }
    
    public int capacite(){
         return this.capacite;
    }
    
    public int taille(){
         return this.stk.size();
    }
    
    public boolean estVide(){
        return this.stk.empty();
    }
    
    public boolean estPleine(){
        return this.stk.size() == this.capacite;
    }
    
    public boolean equals(Object o){
        if( this== o ){
            return true;
        }
        if(!(o instanceof Pile2)){
            return false;
        }
        Pile2 pi = (Pile2)o;

        if (pi.taille() == this.taille() && pi.capacite() == this.capacite()){
            boolean egale = false;
            for(int i= stk.size()-1; i>=0 ; i--){
                Object obj = this.stk.get(i);
                boolean existe = false;
                for(int j = this.stk.size() - 1; j >= 0; j--){
                    if((obj == pi.stk.get(i))){
                        existe = true;
                    }
                }
                if(existe){
                    egale = true;
                } else{
                    return false;
                }

            }
            return true;
        }
        return false;
    }
    
    public int hashCode(){
        return toString().hashCode();
    }
    
    
     public String toString(){
         String s = "[";
        for (int i = this.stk.size() - 1; i >= 0; i--) {
           s+= this.stk.get(i).toString();
           if(i >0){
               s+= ", ";
           }       
        }
        return s + "]"; 
    }
    

    
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2