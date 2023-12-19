package lab4;

public enum Mark
{
    TYT("Toyota"),
    HNDA("Honda"),
    FRD("Ford"),
    CHVY("Chevrolet"),
    NISSN("Nissan"),
    BMW("BMW"),
    MB("Mercedes-Benz"),
    AU("Audi"),
    VW("Volkswagen"),
    HYND("Hyundai"),
    KIA("Kia"),
    MZDA("Mazda"),
    SBARU("Subaru"),
    LEXS("Lexus"),
    TSLA("Tesla"),
    JP("Jeep"),
    VLVO("Volvo"),
    PRSCH("Porsche"),
    FIAT("Fiat"),
    MTSBISHI("Mitsubishi"),
    SZKI("Suzuki"),
    ACR("Acura"),
    CDLLC("Cadillac"),
    LNCLN("Lincoln"),
    BICK("Buick"),
    JGR("Jaguar"),
    LND_RVR("Land Rover"),
    MINI("MINI"),
    RM("Ram"),
    GMC("GMC"),
    CHRYSLR("Chrysler"),
    DODGE("Dodge"),
    ALFA("Alfa Romeo"),
    MRT("Maserati"),
    FRR("Ferrari"),
    LMBRGINI("Lamborghini"),
    ASTN_MRTN("Aston Martin"),
    BNTLY("Bentley"),
    RLLS_RYC("Rolls-Royce"),
    LTS("Lotus"),
    AST("Aston Martin"),
    ALP("Alpine"),
    WIL("Williams"),
    RBR("Red Bull Racing");

    private final String name;

    Mark(String fullName)
    {
        this.name = fullName;
    }

    public String getName()
    {
        return name;
    }
}