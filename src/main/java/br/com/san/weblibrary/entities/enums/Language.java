package br.com.san.weblibrary.entities.enums;

public enum Language {

	AMHARIC(1),
	ARABIC(2),
	BASQUE(3),
	BENGALI(4),
	ENGLISH_UK(5),
	PORTUGUESE_BRAZIL(6),
	BULGARIAN(7),
	CATALAN(8),
	CHEROKEE(9),
	CROATIAN(10),
	CZECH(11),
	DANISH(12),
	DUTCH(13),
	ENGLISH_US(14),
	ESTONIAN(15),
	FILIPINO(16),
	FINNISH(17),
	FRENCH(18),
	GERMAN(19),
	GREEK(20),
	GUJARATI(21),
	HEBREW(22),
	HINDI(23),
	HUNGARIAN(24),
	ICELANDIC(25),
	INDONESIAN(26),
	ITALIAN(27),
	JAPANESE(28),
	KANNADA(29),
	KOREAN(30),
	LATVIAN(31),
	LITHUANIAN(32),
	MALAY(33),
	MALAYALAM(34),
	MARATHI(35),
	NORWEGIAN(36),
	POLISH(37),
	PORTUGUESE_PORTUGAL(38),
	ROMANIAN(39),
	RUSSIAN(40),
	SERBIAN(41),
	CHINESE_PRC(42),
	SLOVAK(43),
	SLOVENIAN(44),
	SPANISH(45),
	SWAHILI(46),
	SWEDISH(47),
	TAMIL(48),
	TELUGU(49),
	THAI(50),
	CHINESE_TAIWAN(51),
	TURKISH(52),
	URDU(53),
	UKRAINIAN(54),
	VIETNAMESE(55),
	WELSH(56);
	
	private int code;
	
	private Language(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	
	public static Language valueOfCode(int code) {
		for(Language language: Language.values()) {
			if(language.getCode() == code) {
				return language;
			}
		}
		
		throw new IllegalArgumentException("Invalid Language code");
	}
}
