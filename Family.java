import java.util.Random;
import java.util.Vector;

public class Family {

    Vector<Sim> family = new Vector<Sim>();
    String lastName = "";
    int funds = 0;

    public void AssignLastName(Family fam, Vector<String> lastNameList)
    {
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(999);
        fam.lastName = lastNameList.elementAt(temp);
    }

    public void DetermineFunds(Family fam)
    {
        int temp = 0;
        Random rand = new Random();
        temp = rand.nextInt(999999);
        fam.funds = temp;
    }

    public void DetermineElderAdultRelations(Family fam)
    {
        int i = 0;
        while(i < fam.family.size())
        {
            if(fam.family.elementAt(i).ageCategory.equals("Elder"))
            {
                int j = 0;
                while(j < fam.family.size())
                {
                    if(fam.family.elementAt(j).ageCategory.equals("Adult"))
                    {
                        if((fam.family.elementAt(j).hairColor.equals(fam.family.elementAt(i).hairColor)) || (fam.family.elementAt(j).eyeColor.equals(fam.family.elementAt(i).eyeColor)))
                        {
                            fam.family.elementAt(i).Children.add(fam.family.elementAt(j));
                            if(fam.family.elementAt(j).Parents.size() < 2) {
                                fam.family.elementAt(j).Parents.add(fam.family.elementAt(i));
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }
    }

    public void DetermineAdultChildrenRelations(Family fam)
    {
        int i = 0;
        while(i < fam.family.size())
        {
            if(fam.family.elementAt(i).ageCategory.equals("Adult"))
            {
                int j = 0;
                while(j < fam.family.size())
                {
                    if(fam.family.elementAt(j).ageCategory.equals("Teen") || fam.family.elementAt(j).ageCategory.equals("Child") || fam.family.elementAt(j).ageCategory.equals("Toddler"))
                    {
                        if((fam.family.elementAt(j).hairColor.equals(fam.family.elementAt(i).hairColor)) || (fam.family.elementAt(j).eyeColor.equals(fam.family.elementAt(i).eyeColor)))
                        {
                            fam.family.elementAt(i).Children.add(fam.family.elementAt(j));
                            if(fam.family.elementAt(j).Parents.size() < 2) {
                                fam.family.elementAt(j).Parents.add(fam.family.elementAt(i));
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }
    }


}


