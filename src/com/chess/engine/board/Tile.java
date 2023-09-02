package com.chess.engine.board;
import com.chess.engine.pieces.Piece;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCords;
    private static final Map<Integer, EmptyTile> emptyTiles = makeAllEmptyTiles();

    private static Map<Integer, EmptyTile> makeAllEmptyTiles() {
        final Map <Integer, EmptyTile> emptyTilesMap = new HashMap<>();
        for (int i = 0; i < 64; i++) {
            emptyTilesMap.put(i, new EmptyTile(i));
        }
        return Collections.unmodifiableMap(emptyTilesMap);
    }

    public static Tile createTile(final int tileCords, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCords, piece) : emptyTiles.get(tileCords);
    }

    private Tile(int tileCords) {
        this.tileCords = tileCords;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        private EmptyTile(int cords) {
            super(cords);
        }

        @Override
        public boolean isTileOccupied() { return false; }

        @Override
        public Piece getPiece() {
            return null;
        }
    }


    public static final class OccupiedTile extends Tile {
        private final Piece pieceOnTile;

        private OccupiedTile(int tileCords, Piece pieceOnTile) {
            super(tileCords);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }


}
