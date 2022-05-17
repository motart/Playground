package CharterUP;

import java.util.HashMap;
import java.util.Map;

public class QuoteCalculator {
    // Prefererably we get this by reading a JSON/properties file on the server so we don't have to redeploy
    // everytime we change our rates, or even a DB. For now hardcoding all values
    public Map<VehicleType, Map<PricingMethod, Double>> rates;

    public QuoteCalculator() {
        rates.put(VehicleType.CHARTER, new HashMap<>(){{
            put(PricingMethod.DAILY, 1000d);
            put(PricingMethod.HOURLY,400d);
            put(PricingMethod.HOURLY,3.5);
        }});

        rates.put(VehicleType.MBUS, new HashMap<>(){{
            put(PricingMethod.DAILY, 925.0);
            put(PricingMethod.HOURLY,360.0);
            put(PricingMethod.HOURLY,3.25);
        }});

        rates.put(VehicleType.CHARTER, new HashMap<>(){{
            put(PricingMethod.DAILY, 1000.0);
            put(PricingMethod.HOURLY,400.0);
            put(PricingMethod.HOURLY,3.5);
        }});

        rates.put(VehicleType.SPRINTER, new HashMap<>(){{
            put(PricingMethod.DAILY, 850.0);
            put(PricingMethod.HOURLY,320.0);
            put(PricingMethod.HOURLY,3.0);
        }});

        rates.put(VehicleType.PBUS, new HashMap<>(){{
            put(PricingMethod.DAILY, 775.0);
            put(PricingMethod.HOURLY,280.0);
            put(PricingMethod.HOURLY,2.75);
        }});

        rates.put(VehicleType.SEDAN, new HashMap<>(){{
            put(PricingMethod.DAILY, 700.0);
            put(PricingMethod.HOURLY,240.0);
            put(PricingMethod.HOURLY,2.5);
        }});

        rates.put(VehicleType.SUV, new HashMap<>(){{
            put(PricingMethod.DAILY, 625.0);
            put(PricingMethod.HOURLY,200.0);
            put(PricingMethod.HOURLY,2.25);
        }});

        rates.put(VehicleType.LIMO, new HashMap<>(){{
            put(PricingMethod.DAILY, 550.0);
            put(PricingMethod.HOURLY,160.0);
            put(PricingMethod.HOURLY,2.0);
        }});

        rates.put(VehicleType.TROLLEY, new HashMap<>(){{
            put(PricingMethod.DAILY, 475.0);
            put(PricingMethod.HOURLY,120.0);
            put(PricingMethod.HOURLY,1.75);
        }});
    }


    public Double generateQuote (VehicleType vehicleType,  PricingMethod pricingMethod,  int vehicleCount,
                              int pricingMethodUnits) {
        return vehicleCount * getVehicleRate(vehicleType, pricingMethod) * pricingMethodUnits;
    }

    private Double getVehicleRate(VehicleType type,  PricingMethod pricingMethod) {
        return rates.get(type).get(pricingMethod);
    }
    public enum PricingMethod {
        DAILY,
        HOURLY,
        DISTANCE
    }

    enum VehicleType {
        MBUS,
        SPRINTER,
        PBUS,
        CBUS,
        SEDAN,
        SUV,
        LIMO,
        TROLLEY,
        CHARTER
    }
}
