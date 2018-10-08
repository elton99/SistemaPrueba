
package examen3;

public class Examen3 {

    public static void main(String[] args) {
        //Creamos dos arrays de cada tipo de objeto
        Serie listaSeries[]=new Serie[5];
        Peliculas listaPeliculas[]=new Peliculas[5];
  
        //Creamos un objeto en cada posicion del array
        listaSeries[0]=new Serie();
        listaSeries[1]=new Serie("Juego de tronos", "George R. R. Martin ");
        listaSeries[2]=new Serie("Los Simpsons", 15, "Humor", "Matt Groening");
        listaSeries[3]=new Serie("Padre de familia", 12 ,"Humor", "Seth MacFarlane");
        listaSeries[4]=new Serie("Breaking Bad", 5, "Thriller", "Vince Gilligan");
  
        listaPeliculas[0]=new Peliculas();
        listaPeliculas[1]=new Peliculas("El gato con botas", 90 , "Aventura","2010");
        listaPeliculas[2]=new Peliculas("Warcraf", "2014");
        listaPeliculas[3]=new Peliculas("El perro cobarde", 100, "Comedia", "2011");
        listaPeliculas[4]=new Peliculas("Thor", 110, "Acción", "2012");
  
        //entregamos algunos peliculas y series
        listaSeries[1].entregar();
        listaSeries[4].entregar();
        listaPeliculas[0].entregar();
        //listaPeliculas[3].entregar();
  
        //Recorremos los arrays para contar cuantos entregados hay, tambien los devolvemos
  
        int entregados=0;
  
        for(int i=0;i<listaSeries.length;i++){
            if(listaSeries[i].isEntregado()){
                entregados+=1;
                listaSeries[i].devolver();
  
            }
            if(listaPeliculas[i].isEntregado()){
                entregados+=1;
                listaPeliculas[i].devolver();
            }
        }
  
        System.out.println("Hay "+entregados+" articulos vistos");
  
        //Creamos dos objetos con la primera posicion de cada array
        Serie serieMayor=listaSeries[0];
        Peliculas videojuegoMayor=listaPeliculas[0];
  
        //Recorremos el array desde la posicion 1 (no 0), comparando el mayor con las posiciones del array
        for(int i=1;i<listaSeries.length;i++){
            if(listaSeries[i].compareTo(serieMayor)==Serie.MAYOR){
                serieMayor=listaSeries[i];
            }
            if(listaPeliculas[i].compareTo(videojuegoMayor)==Peliculas.MAYOR){
                videojuegoMayor=listaPeliculas[i];
            }
  
        }
  
        //Mostramos toda la informacion de peliculas y serie mayor
        System.out.println(videojuegoMayor);
        System.out.println(serieMayor);
    }
    }
    
