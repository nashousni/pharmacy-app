-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pharmadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pharmadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pharmadb` DEFAULT CHARACTER SET utf8 ;
USE `pharmadb` ;

-- -----------------------------------------------------
-- Table `pharmadb`.`famille_produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`famille_produit` (
  `codefam` VARCHAR(50) NOT NULL,
  `nomfam` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codefam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`stocker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`stocker` (
  `id_stock` INT NOT NULL AUTO_INCREMENT,
  `qte_entre` INT NULL,
  `qte_sortie` INT NULL,
  `qte_reel` INT NULL,
  `date_stock` DATE NULL,
  PRIMARY KEY (`id_stock`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`produit` (
  `codep` INT NOT NULL AUTO_INCREMENT,
  `prixp` DOUBLE NULL,
  `datep` DATE NULL,
  `nomfab` VARCHAR(45) NULL,
  `libellep` VARCHAR(45) NULL,
  `codefam` VARCHAR(50) NOT NULL,
  `id_stock` INT NOT NULL,
  `produitcol` VARCHAR(45) NULL,
  `produitcol1` VARCHAR(45) NULL,
  PRIMARY KEY (`codep`),
  CONSTRAINT `fk_produit_famille_produit1`
    FOREIGN KEY (`codefam`)
    REFERENCES `pharmadb`.`famille_produit` (`codefam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produit_stocker1`
    FOREIGN KEY (`id_stock`)
    REFERENCES `pharmadb`.`stocker` (`id_stock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`fournisseur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`fournisseur` (
  `numf` INT NOT NULL AUTO_INCREMENT,
  `nomf` VARCHAR(45) NULL,
  `adressef` VARCHAR(45) NULL,
  `telf` VARCHAR(45) NULL,
  PRIMARY KEY (`numf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`livraison`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`livraison` (
  `codeLiv` INT NOT NULL AUTO_INCREMENT,
  `dateLiv` DATE NULL,
  `qteLiv` INT NULL,
  `prixUnitaire` DOUBLE NULL,
  `montant` DOUBLE NULL,
  `codep` VARCHAR(25) NOT NULL,
  `numf` INT NOT NULL,
  PRIMARY KEY (`codeLiv`),
  CONSTRAINT `fk_livraison_produit`
    FOREIGN KEY (`codep`)
    REFERENCES `pharmadb`.`produit` (`codep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livraison_fournisseur1`
    FOREIGN KEY (`numf`)
    REFERENCES `pharmadb`.`fournisseur` (`numf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`depense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`depense` (
  `code_depense` INT NOT NULL AUTO_INCREMENT,
  `montant` DOUBLE NULL,
  `intitule` VARCHAR(45) NULL,
  `date_op` DATE NULL,
  PRIMARY KEY (`code_depense`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`depot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`depot` (
  `numdepot` INT NOT NULL AUTO_INCREMENT,
  `nomdepot` VARCHAR(45) NULL,
  `adresse_depot` VARCHAR(45) NULL,
  PRIMARY KEY (`numdepot`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`client` (
  `codecli` INT NOT NULL AUTO_INCREMENT,
  `nomcli` VARCHAR(45) NULL,
  `adresse` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  PRIMARY KEY (`codecli`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`vente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`vente` (
  `numv` INT NOT NULL AUTO_INCREMENT,
  `libellev` VARCHAR(45) NULL,
  `qtev` DECIMAL NULL,
  `datev` DATE NULL,
  `montant` DOUBLE NULL,
  `montant_net` DOUBLE NULL,
  `codep` INT NOT NULL,
  `remise` DECIMAL NULL,
  `codecli` INT NOT NULL,
  PRIMARY KEY (`numv`),
  CONSTRAINT `fk_vente_produit1`
    FOREIGN KEY (`codep`)
    REFERENCES `pharmadb`.`produit` (`codep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vente_client1`
    FOREIGN KEY (`codecli`)
    REFERENCES `pharmadb`.`client` (`codecli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`reglement_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`reglement_client` (
  `numreg` INT NOT NULL AUTO_INCREMENT,
  `modereg` VARCHAR(45) NULL,
  `montant` DOUBLE NULL,
  `solde` DOUBLE NULL,
  `date_reg` DATE NULL,
  `codecli` INT NOT NULL,
  `numcheque` INT NULL,
  PRIMARY KEY (`numreg`),
  CONSTRAINT `fk_reglement_client_client1`
    FOREIGN KEY (`codecli`)
    REFERENCES `pharmadb`.`client` (`codecli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`recette`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`recette` (
  `coderecet` INT NOT NULL AUTO_INCREMENT,
  `intitule_rect` VARCHAR(45) NULL,
  `date_op` DATE NULL,
  `numv` VARCHAR(45) NULL,
  PRIMARY KEY (`coderecet`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_user`));


-- -----------------------------------------------------
-- Table `pharmadb`.`Employe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`Employe` (
  `NoEmp` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NULL,
  `Prenom` VARCHAR(45) NULL,
  `Fonction` VARCHAR(45) NULL,
  `DateNaissance` DATE NULL,
  `DateEmbauche` DATE NULL,
  `Adresse` VARCHAR(45) NULL,
  `TeEmp` VARCHAR(45) NULL,
  `  RendCompteA` INT NULL,
  PRIMARY KEY (`NoEmp`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`Commande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`Commande` (
  `NoCom` INT NOT NULL AUTO_INCREMENT,
  `NoFour` INT NOT NULL,
  `NoEmp` INT NOT NULL,
  `DateCom` DATE NULL,
  PRIMARY KEY (`NoCom`),
  CONSTRAINT `fk_Commande_fournisseur1`
    FOREIGN KEY (`NoFour`)
    REFERENCES `pharmadb`.`fournisseur` (`numf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Commande_Employe1`
    FOREIGN KEY (`NoEmp`)
    REFERENCES `pharmadb`.`Employe` (`NoEmp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmadb`.`DetailCommande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmadb`.`DetailCommande` (
  `NoCom` INT NOT NULL,
  `CodeP` VARCHAR(45) NOT NULL,
  `PrixUnit` DOUBLE NULL,
  `Qte` INT NULL,
  `Remise%` DECIMAL NULL,
  CONSTRAINT `fk_DetailCommande_produit1`
    FOREIGN KEY (`CodeP`)
    REFERENCES `pharmadb`.`produit` (`codep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailCommande_Commande1`
    FOREIGN KEY (`NoCom`)
    REFERENCES `pharmadb`.`Commande` (`NoCom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;