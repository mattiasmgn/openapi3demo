package se.democlient;

import java.util.List;

import se.democlient.client.ApiException;
import se.democlient.model.ClassA;
import se.democlient.model.ClassB;
import se.democlient.model.EpList200ResponseInner;
import se.democlient.model.InterfaceC;
//import se.democlient.model.OneOfinlineResponse200;
//import se.democlient.model.InlineResponse200;


public class App
{
    public static void main( String[] args )
    {
        new App().tst();
    }

    private void tst() {
        DemoControllerApi demoControllerApi = new DemoControllerApi();

        ClassA classA = null;
        try {
            System.out.println("Calling ep a");
            classA = demoControllerApi.epA();
            System.out.println("classA="+classA);
            System.out.println("classA.getCurrentTime: "+classA.getCurrentTime());
            System.out.println("classA.getOnlyInA: "+classA.getOnlyInA());

            System.out.println("-----------------------------------------------------");
            System.out.println("Calling ep b");
            ClassB classB = null;
            classB = demoControllerApi.epB();
            System.out.println("classB="+classB);
            System.out.println("classB.getCurrentTime: "+classB.getCurrentTime());

            System.out.println("-----------------------------------------------------");
            System.out.println("Calling ep c");
            EpList200ResponseInner oneOfinlineResponse200 = demoControllerApi.epC();
            System.out.println("oneOfinlineResponse200 = " + oneOfinlineResponse200);
            System.out.println("oneOfinlineResponse200.type = " + oneOfinlineResponse200.getSchemaType());


            if (oneOfinlineResponse200.getActualInstance() instanceof ClassA){
                System.out.println("instance of A");
                ClassA a = oneOfinlineResponse200.getClassA();
                String onlyInA = a.getOnlyInA();
                System.out.println("only in a: "+onlyInA);
            }
            else if (oneOfinlineResponse200.getActualInstance() instanceof ClassB){
                System.out.println("instance of B");
                ClassB b = oneOfinlineResponse200.getClassB();
                String bt= b.getCurrentTime();
                System.out.println("currentTime = " + bt);
            }
            else {
                System.out.println("oneOfinlineResponse200 is not instance of Class A or ClassB");
            }
            /*
            System.out.println("-----------------------------------------------------");
            String currentTime = ((InterfaceC) oneOfinlineResponse200).getCurrentTime();
            System.out.println("currentTime according to interface = " + currentTime);

            String type = ((InterfaceC) oneOfinlineResponse200).getType();
            System.out.println("type="+type);

             */
            System.out.println("-----------------------------------------------------");
            System.out.println("Calling ep list");
            List<EpList200ResponseInner> objects = demoControllerApi.epList();
            System.out.println("objects = " + objects);
            Class<?> aClass = objects.get(0).getClass();
            System.out.println("aClass = " + aClass);



        } catch (ApiException e) {
            e.printStackTrace();
        }


    }
}
