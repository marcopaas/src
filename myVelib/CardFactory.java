package project;

public class CardFactory{
    public RegistrationCard createCard(String cardType, String username){
    	
        if(cardType==null)
        {
            return null;
        }
        
            if(cardType.equalsIgnoreCase("Vlibre"))
                return new VlibreCard(username);
            else if(cardType.equalsIgnoreCase("Vmax"))
                return new VmaxCard(username);
            return null; //OR print invalid card type
        
        
    }
}