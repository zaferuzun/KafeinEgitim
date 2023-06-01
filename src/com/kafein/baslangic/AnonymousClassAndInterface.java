package com.kafein.baslangic;

public class AnonymousClassAndInterface {

    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public String name() {
                return "KUŞ";
            }
        };

        System.out.println(animal.name());

        Animal animal2 = new Animal() {
            @Override
            public String name() {
                return "kuş degil :)";
            }
        };

        System.out.println(animal2.name());

        /******************************************/

        Game game = new Game() {
            @Override
            public String name() {
                return "Lol";
            }

            @Override
            public String size() {
                return "5gb";
            }

            public String toString() {
                return name() + " " + size();
            }
        };
        System.out.println(game.toString());

    }

    interface Animal{
        String name();
    }


    interface Game{
        String name();
        String size();
    }



}
