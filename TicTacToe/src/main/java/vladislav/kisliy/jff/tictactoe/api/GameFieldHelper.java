/*
 * Copyright (C) 2015 Weigandt Consulting
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.tictactoe.api;

import vladislav.kisliy.jff.tictactoe.beans.CellState;
import vladislav.kisliy.jff.tictactoe.beans.Game;
import java.util.List;

/**
 *
 * @author vlad
 */
public interface GameFieldHelper {

    Boolean isWinner(List<CellState> gameField, CellState player);

    Boolean isGameOver(List<CellState> gameField);

    Game analyzeGame(List<CellState> gameField);
    
    List<CellState> getNewField();

    List<Integer> getAvailableMoves(List<CellState> gameField);

    List<CellState> doStep(List<CellState> gameField, CellState playerSign, Integer position);
    
    Boolean isFieldEmpty(List<CellState> gameField);
    
    boolean isCorrectTurn(List<CellState> gameFieldBefore, List<CellState> gameFieldAfter);
}
