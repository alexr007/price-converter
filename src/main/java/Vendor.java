import process.sp.SpStripSpaces;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by alexr on 12.02.2017.
 */
class Vendor {
    private final String fileName;
    private final HashMap<String, Integer> map = new HashMap<>();
    private Set<String> vendors;

    Vendor(String fileName) {
        this.fileName = fileName.toUpperCase();
        fillMap();
    }

    /* to make method body
     * use:
     *
     * select 'map.put("'||v_name||'"', v_id||');' from vendors
     *
     */
    private void fillMap() {
        map.put("MOPAR",1);
        map.put("FORD",2);
        map.put("TIMKEN",3);
        map.put("NATIONAL",4);
        map.put("CROWN",5);
        map.put("SPICER",6);
        map.put("GM",7);
        map.put("AC-DELCO",8);
        map.put("GATES",9);
        map.put("ENGINETECH",10);
        map.put("SYNERGY",11);
        map.put("FOX",12);
        map.put("BILSTEIN",13);
        map.put("MOOG",14);
        map.put("DORMAN",15);
        map.put("MOTORCRAFT",16);
        map.put("CONTINENTAL",17);
        map.put("VICTOR REINZ",18);
        map.put("CENTRIC",19);
        map.put("HONDA",20);
        map.put("ACURA",21);
        map.put("MONROE",22);
        map.put("BRP",23);
        map.put("DAYCO",24);
        map.put("FIAT",25);
        map.put("TOYOTA",26);
        map.put("ZF",27);
        map.put("PORSCHE",28);
        map.put("SKODA",32);
        map.put("SCANIA",33);
        map.put("LAND ROVER",34);
        map.put("JAGUAR",35);
        map.put("CITROEN",36);
        map.put("PEUGEOT",37);
        map.put("MAZDA",38);
        map.put("MASERATI",39);
        map.put("IVECO",40);
        map.put("MITSUBISHI",41);
        map.put("MERCEDES",42);
        map.put("MAN",43);
        map.put("KIA",44);
        map.put("HYUNDAI",45);
        map.put("SUBARU",47);
        map.put("VOLKSWAGEN",48);
        map.put("BMW",49);
        map.put("VOLVO",50);
        vendors = map.keySet();
    }

    int id() {
        int id = 0;
        for (String vendor : vendors) {
            if (fileName.contains(new SpStripSpaces(vendor).data())) {
                id = map.get(vendor);
                break;
            }
        }
        return id;
    }

    String name() {
        String name = "";
        for (String vendor:vendors) {
            if (fileName.contains(new SpStripSpaces(vendor).data())) {
                name=vendor;
                break;
            }
        }
        return name;
    }
}
