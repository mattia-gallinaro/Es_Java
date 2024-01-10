public class ClInterneTester
{
    public static void main(String[] args)
    {
        ClEsterna e = new ClEsterna();  //tutto ok

        //MAI LECITO: il tipo di i deve essere ClEsterna.ClInterna
        //Clinterna i = e.metEsterno(); 

        //MAI LECITO: non si puo` creare un oggetto di ClInterna qui
        //ClEsterna.ClInterna obj = new ClEsterna.ClInterna();

        //LECITO SOLO SE ClInterna e` public in ClEsterna
        ClEsterna.ClInterna i = e.metEsterno();

        //LECITO SOLO SE sia ClInterna che il metodo sono public
        (e.metEsterno()).metInterno();
        //LECITO SOLO SE sia ClInterna che il campo sono public
        //(e.metEsterno()).campointerno = 1;

        //SEMPRE LECITO (ma inutile se ClInterna e` private)
        e.metEsterno();
    }
}
