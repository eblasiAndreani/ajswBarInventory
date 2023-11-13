package com.ajsw.barInventory;
import com.ajsw.barInventory.domain.dto.drink.Drink;
import com.ajsw.barInventory.domain.dto.drink.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;
import com.ajsw.barInventory.repository.IDrinkRepository;
import com.ajsw.barInventory.service.impl.DrinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DrinkServiceTest {

    @InjectMocks
    private DrinkService drinkService;

    @Mock
    private IDrinkRepository drinkRepository;

    @Test
    public void testGetByBar() {
        int barId = 1;
        List<DrinkEntity> drinkEntities = Arrays.asList(/* Mocked DrinkEntity objects */);
        when(drinkRepository.findByIdBar(barId)).thenReturn(drinkEntities);

        List<Drink> result = drinkService.getByBar(barId);

        assertEquals(drinkEntities.size(), result.size());
    }

    @Test
    public void testGetAll() {
        List<DrinkEntity> drinkEntities = Arrays.asList();
        when(drinkRepository.findAll()).thenReturn(drinkEntities);

        List<Drink> result = drinkService.getAll();

        assertEquals(drinkEntities.size(), result.size());
    }

    @Test
    public void testCreateDrink() {
        RequestDrinkPostDto requestDto = new RequestDrinkPostDto();
        requestDto.setIdBar(1);

        assertNotNull(requestDto.getIdBar(), "IdBar must not be null");

        Drink result = drinkService.createDrink(requestDto);

        assertNotNull(result);
    }
}

