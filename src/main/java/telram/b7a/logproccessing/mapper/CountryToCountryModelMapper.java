package telram.b7a.logproccessing.mapper;

import org.mapstruct.Mapper;
import telram.b7a.logproccessing.model.Country;
import telram.b7a.logproccessing.model.CountryEntity;

@Mapper(componentModel = "spring")
public interface CountryToCountryModelMapper {
    Country countryEntityToCountry(CountryEntity countryEntity);


}
