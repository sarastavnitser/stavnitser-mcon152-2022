import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ScrabblePresenterTest {
    private ScrabbleFrame view = Mockito.mock(ScrabbleFrame.class);
    private ScrabbleGame model = Mockito.mock(ScrabbleGame.class);
    private ScrabblePresenter presenter = new ScrabblePresenter(view, model);
    private List<Character> tiles = new ArrayList<>();
    @Test
    public void fillTiles() {
        //given

        doReturn(tiles).when(model).getTiles();

        //when
        presenter.fillTiles();

        //then
        verify(model).getTiles();
        verify(view).setTiles(tiles);
    }

    @Test
    public void playWord_true(){
        //given
        doReturn(tiles).when(model).getTiles();
        doReturn(model.getStrTrue()).when(model).playWord("HELLO");

        //when
        presenter.playWord("HELLO");

        //then
        verify(model).playWord("HELLO");
        verify(view).setScore("1");
        verify(model).getTiles();
        verify(view).setTiles(tiles);
    }

    @Test
    public void playWord_notInTiles(){
        //given
        doReturn(tiles).when(model).getTiles();
        doReturn(model.getNotInTiles()).when(model).playWord("LOGO");

        //when
        presenter.playWord("LOGO");

        //then
        verify(model).playWord("LOGO");
        verify(view).setErrorMessageLabel(model.getNotInTiles());

    }



}