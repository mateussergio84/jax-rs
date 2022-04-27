package br.com.teste.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.model.Pessoa;

public class Service {

	Connection con;

	public void conect() {
		try {
			String url = String.format("jdbc:mysql://localhost:3306/api");
			String uname = "root";
			String pwd = "";

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pwd);
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess.");
		}
	}

	public Pessoa insertUser(Pessoa pessoa) {
		String insert = "insert into pessoa(nome, idade) values(?,?) ";
		conect();
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess.");
		}
		return pessoa;

	}

	public ArrayList<Pessoa> getUser() throws SQLException {
		conect();
		ArrayList<Pessoa> data = new ArrayList<Pessoa>();
		String select = "select * from pessoa";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Pessoa p = new Pessoa();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("nome"));
			p.setIdade(rs.getInt("idade"));
			data.add(p);
		}
		return data;
	}

	public ArrayList<Pessoa> getUserById(int id) throws SQLException {
		conect();
		ArrayList<Pessoa> data = new ArrayList<Pessoa>();
		String select = "select * from pessoa where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Pessoa p = new Pessoa();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("nome"));
			p.setIdade(rs.getInt("idade"));
			data.add(p);
		}
		return data;
	}

	public Pessoa updatetUser(Pessoa p) {
		conect();
		String insert = "update pessoa set nome=? , idade=? where id =?";

		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getIdade());
			ps.setInt(3, p.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess.");
		}

		return p;

	}

	public int deletetUser(int id) {
		conect();
		String insert = "delete from pessoa where id =?";

		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess.");
		}
		return id;
	}
}
