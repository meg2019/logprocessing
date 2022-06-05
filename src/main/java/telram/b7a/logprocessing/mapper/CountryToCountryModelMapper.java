package telram.b7a.logprocessing.mapper;

import org.mapstruct.Mapper;
import telram.b7a.logprocessing.model.Country;
import telram.b7a.logprocessing.model.CountryEntity;

@Mapper(componentModel = "spring")
public interface CountryToCountryModelMapper {
    Country countryEntityToCountry(CountryEntity countryEntity);


}
