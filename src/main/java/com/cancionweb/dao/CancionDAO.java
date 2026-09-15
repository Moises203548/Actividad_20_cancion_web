package com.cancionweb.dao;

import com.cancionweb.model.Cancion;
import com.cancionweb.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancionDAO {

    public boolean crear(Cancion cancion) {
        String sql = "INSERT INTO cancion (nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete, autor, fechaLanzamiento) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            setParametros(ps, cancion);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cancion> listarTodos() {
        List<Cancion> lista = new ArrayList<>();
        String sql = "SELECT * FROM cancion ORDER BY id";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearCancion(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cancion buscarPorId(int id) {
        String sql = "SELECT * FROM cancion WHERE id = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearCancion(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizar(Cancion cancion) {
        String sql = "UPDATE cancion SET nombre=?, ritmo=?, duracion=?, album=?, posicionEnAlbum=?, " +
                "banda=?, interprete=?, autor=?, fechaLanzamiento=? WHERE id=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            setParametros(ps, cancion);
            ps.setInt(10, cancion.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cancion WHERE id = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Cancion> reportePorDuracion(int minSegundos, int maxSegundos) {
        List<Cancion> lista = new ArrayList<>();
        String sql = "SELECT * FROM cancion WHERE duracion BETWEEN ? AND ? ORDER BY duracion";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, minSegundos);
            ps.setInt(2, maxSegundos);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCancion(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Cancion> reportePorRitmo(String ritmo) {
        List<Cancion> lista = new ArrayList<>();
        String sql = "SELECT * FROM cancion WHERE ritmo LIKE ? ORDER BY nombre";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + ritmo + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCancion(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    private void setParametros(PreparedStatement ps, Cancion c) throws SQLException {
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getRitmo());
        ps.setInt(3, c.getDuracion());
        ps.setString(4, c.getAlbum());
        ps.setInt(5, c.getPosicionEnAlbum());
        ps.setString(6, c.getBanda());
        ps.setString(7, c.getInterprete());
        ps.setString(8, c.getAutor());
        ps.setDate(9, c.getFechaLanzamiento() != null && !c.getFechaLanzamiento().isEmpty()
                ? Date.valueOf(c.getFechaLanzamiento()) : null);
    }

    private Cancion mapearCancion(ResultSet rs) throws SQLException {
        Cancion c = new Cancion();
        c.setId(rs.getInt("id"));
        c.setNombre(rs.getString("nombre"));
        c.setRitmo(rs.getString("ritmo"));
        c.setDuracion(rs.getInt("duracion"));
        c.setAlbum(rs.getString("album"));
        c.setPosicionEnAlbum(rs.getInt("posicionEnAlbum"));
        c.setBanda(rs.getString("banda"));
        c.setInterprete(rs.getString("interprete"));
        c.setAutor(rs.getString("autor"));
        Date fecha = rs.getDate("fechaLanzamiento");
        c.setFechaLanzamiento(fecha != null ? fecha.toString() : "");
        return c;
    }
}