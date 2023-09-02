package com.chess.engine.pieces;


import com.chess.engine.Team;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import java.util.List;

public abstract class Piece {
    protected final int piecePosition;
    protected final Team teamcolor;

    Piece (final int piecePosition, final Team teamcolor) {
        this.teamcolor = teamcolor;
        this. piecePosition = piecePosition;
    }

    public abstract List<Move> legalMoves( final Board board);


}
