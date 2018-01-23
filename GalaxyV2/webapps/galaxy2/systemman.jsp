<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html; charset=Windows-31J"%>
<%
%>


<HTML lang="ja">
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset= Shift_JIS">
<META name="robots" content="index,follow">
<TITLE>システムについて</TITLE>
<SCRIPT LANGUAGE="JavaScript">
<!--
//-->
</SCRIPT>
<style type="text/css">
<!--
a {	color:#44AAFF; } a:hover { color:#4D2B57; background-color:#99BBFF; text-decoration:none; }
-->
</style>

</HEAD>

<BODY marginwidth="0px" marginheight="10px" leftMargin="0px" topMargin="10px" bgcolor="#ffffff">
<CENTER>
<TABLE cellpadding="0" cellspacing="0" border="0" bordercolor="yellow" width="950">
  <TBODY>
    <TR>
      <TD align="center">
      <TABLE cellpadding="0" cellspacing="0" border="0" bordercolor="red" width="950">
        <TBODY>
          <TR>
            <TD colspan="3" align="center" bgcolor="blue">
			<%@ include file="include/header.htm" %>
            </TD>
          </TR>
		  <TR>
		  	<TD colspan="3" height="2" align="center" bgcolor="white">
			</TD>
		  </TR>
          <TR>
		  <TD width="200" valign="top" background="image/background.jpg">
			<%@ include file="include/menu.htm" %>
			</TD>
			<TD width="740" height="700">
<P align="center"><B><FONT size="+3">糖鎖マップとは？</FONT></B></P>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"><BR>
</P>
<UL>
  <LI><A href="#GAIYO"><FONT size="+1"><B>はじめに</B></FONT></A>
  <LI><A href="#GU"><FONT size="+1"><B>グルコース単位</B></FONT></A>
  <LI><A href="#MAP"><FONT size="+1"><B>2-D/3-D糖鎖マップの作り方</B></FONT></A>
  <LI><A href="#TOUSA"><FONT size="+1"><B>糖鎖構造解析法</B></FONT></A>
  <LI><A href="#PARAM"><FONT size="+1"><B>UCのパラメーター化</B></FONT></A>
  <LI><FONT size="+1"><B><A href="#CODE">コード番号</A></B></FONT>
  <LI><A href="#SYAJI"><FONT size="+1"><B>謝辞</B></FONT></A>
</UL>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"><BR>
<P><BR><BR>
</P>
<P><A NAME="GAIYO"><B><FONT size="+1">はじめに</FONT></B>　：</A><BR>
　糖蛋白質の、 アスパラギン残基に結合している糖鎖
(N型糖鎖) の構造解析法として私達が開発してきた
&quot;2-D/3-D 糖鎖マッピング法&quot; について簡単に解説します。<BR>
<BR>
　この分析法は、 まず糖鎖を酵素的に蛋白質から切り離し、
糖鎖の還元末端を ２-アミノピリジンで蛍光ラベルします。このPA糖鎖を、
３種類の分離モードのHPLCカラムを用いて連続的に分離すると同時に、
その溶出位置から構造を推定するという仕組みです。<BR>
<BR>
　構造の同定の基本は、試料PA糖鎖のカラムからの溶出位置を、
マップ上の既知の標準PA糖鎖の位置と比較することですが、
必要に応じて標準糖鎖との共打ち、 また各種グリコシダーゼ消化前後のカラムからの溶出位置の変化をマップ上でグラフィカルに追跡することにより構造を解析します。<BR>
<BR>
　この手法は、 中性糖鎖とシアリル糖鎖が全く同じカラム、
同じ溶出条件で分離同定できる点が便利で優れており、
また単に糖鎖の分離精製法としての観点だけから見ても良い方法なので、
NMRや質量分析のための糖鎖の単離精製という目的に使える利点があります。<BR>
<BR>
　この分析法では蛋白質が１ｍｇあれば大抵の場合は糖鎖分析が可能です。
HPLCカラムでは、 ピコモル ( pmol ) 及至フェムトモル
( fmol) のPA糖鎖の検出ができます。<BR>
<BR>
　構造を同定した糖鎖1つ1つには数字と必要に応じてアルファベットを組み合わせたコード番号　（例えば110.4Fや3A1-300.8)
をつけて体系的に分類しています。<BR><BR>
　今回公開した最新のデータベースは、 これまでに解析蓄積した500種類に及ぶPA糖鎖の構造式、
ODSカラム及びアミドカラムにおける溶出位置、
マススペクトロメトリーで得られるPA糖鎖の分子量、
コード番号、 試料糖鎖の起源、 参考文献が含まれています。</P>
<P><BR><BR>
</P>
<P><A NAME="GU"><B><FONT size="+1">グルコース単位（GU）　：</FONT></B></A><BR>
　グルコース単位 ( GU ) とは、 本質的には試料の溶出時間を表しています。
個々のカラムによる差、 経時変化、 用時に調製する溶媒の微妙な違い等から生ずる試料の溶出時間の差異に普遍性を与えるために、
試料の溶出時間をグルコースの重合度に換算してGUとして表現しています。</P>
<P align="center"><A href="fig1.html" target="_blank"><IMG src="image/fig1.png" border="0" alt="拡大"></A><BR>
<B><FONT size="+1">図１</FONT></B>　<FONT size="+1">グルコース単位 (GU) の計算</FONT></P>
<P><BR>
</P>
<P>　どのようにして試料の溶出時間をGUで表すか説明します（図１）。<BR>
ODSカラムとアミドカラムにそれぞれ市販の標準PA化グルコース重合体混合物を当日試料を分析する前に流すことによって試料のカラムからの溶出位置が補正規格化されます。
４，５，６等の数字は各グルコースの重合度を示します。　赤色ピークは試料糖鎖の溶出位置を示します。<BR>
　PA糖鎖試料のピークの溶出時間をグルコース重合体の溶出時間と比較してGUに換算し、
2-Dマップ上の値とします。 次にこの例では試料糖鎖のX軸上の座標14.7とY軸上の座標6.7を1組の座標
( 赤い点 ) としてマップに目盛り、 既知のデータ
( 青い点 )　と比較しています。<BR>
<BR>
　最初に<I>Analytical Biochemistry</I> 誌に113個の糖鎖構造とその2-Dマップ上のGUが発表されたのは1988年ですが、
その時の値は今でも全く訂正の必要がありません。
ただ、 カラムは私達が使用しているもの ( Shim-pack
CLC-ODS カラム および Amide-80 カラム） と同じでないと
GU値が合わないようです。</P>
<P><BR><BR>
</P>
<P><A NAME="MAP"><B><FONT size="+1">2-D / 3-D 糖鎖マップの作り方</FONT></B>　：</A><BR>
　2-Dマップ法と3-Dマップ法の関係：　2-D マップ法は3-Dマップ法に完全に含まれています。<BR>
　　（１）　PA糖鎖の混合物をDEAE ( diethylaminoethyl
) カラムなどの陰イオン交換カラムでシアル酸残基の数によって中性糖鎖、
モノシアリル糖鎖、 ジシアリル糖鎖のように分離します。
これが3-Dマップ法の第1段階です。<BR>
　　（２）　次に、分離の原理の異なる2種類のカラムを用いたHPLCで、
先にチャージによって分かれた中性糖鎖、 モノシアリル糖鎖、
ジシアリル糖鎖などの画分をそれぞれ分離精製し、
それと同時に各糖鎖の溶出位置から、 その構造を推定するのが2-Dマップ法です。
2-Dマップ法で最初に使うODSカラムは、 たとえ同じ分子サイズの異性体でも残基の結合位置の違いなど微細な違いを見分け分離することができ、
分離は実にシャープです。<BR>
　　（３) 　ODSカラムから溶出した各分画を、
アミドカラムで分離精製します。 この第３のカラムは主として糖鎖の分子サイズによって分離することができます。<BR>
　　(４）　試料PA糖鎖の、 X軸及びY軸の座標を、
2-Dマップ上にプロットします。<BR>
　　(５)　同様にしてDEAEカラムで分離されたシアル酸数の異なる各ピークをそれぞれ上記の(2)
- (4) の方法で分離し 3-Dマップを作り上げます。　<BR>
<BR>
　図２で説明します。<BR>
　3-D マップ法の最初のカラムであるDEAEカラム
(a) で分離した試料のピークは、 (b) のようにそれぞれ別々の
(中性糖鎖、モノシアリル糖鎖、ジシアリル糖鎖等の)
2-Dマップ上に目盛ります。　(b) で別々のチャートに目盛った座標は、(c)
のように1枚のマップに重ねて表示することも可能です。　それは、中性糖鎖もシアリル糖鎖もマップ法の分離条件　（緩衝液の組成、
グラジエントの変化）が全く同一なので、 サンプルの数が少なければ、1枚のマップに目盛ることもできるのです。　しかし、試料数が多い場合は、(d)
のように別々にしたほうが重なる点が少ないので、
原則としてシアリル糖鎖はDEAEカラムで分けた後それぞれ別のマップで同定したほうがよいでしょう。
(c) で重なっていた点は、(d) ではすべて完全に分かれています。</P>
<P align="center"><IMG src="image/fig2.png" width="575" height="471" border="0"><BR>
<FONT size="+1"><B>図２</B></FONT>　　<FONT size="+1">2-D/3-D 糖鎖マップの作り方</FONT></P>
<P><BR><BR>
</P>
<P><A NAME="TOUSA"><B><FONT size="+1">糖鎖構造解析法　：</FONT></B></A><BR>
　　N型糖鎖の構造は、　トリマンシルコアを幹として枝を広げた樹の形状にたとえられます。
現在登録された500個近い既知糖鎖の構造は、　すべて61種の糖残基ユニットの組み合わせによる糖鎖ツリーとして書き表すことができます
(図3)。</P>
<P align="center"><A href="odsparam.html" target="_blank"><IMG src="image/fig3ods.png" border="0" alt="拡大"></A><A href="amideparam.html" target="_blank"><IMG src="image/fig3amide.png" border="0" alt="拡大"></A><BR>
<BR>
<B><FONT size="+1">図３</FONT></B>　<FONT size="+1">UC値を表した糖鎖ツリー</FONT></P>
<P><BR>
</P>
<P>個々の試料の糖鎖構造解析法は、　試料のPA糖鎖のマップ上の位置を、　既知の標準PA糖鎖の位置と比較することで構造を推定するものです。
　その方法の要点は、<BR><BR>
　1. まず得られた試料PA糖鎖の座標値から±5%程度の範囲にある標準糖鎖を検索して、　幾つかの候補を選び出します。<BR>
<BR>
　２．試料PA糖鎖と、　選ばれた候補の標準糖鎖の1つとを、　ODS及びアミドのHPLCカラムによって共打ち試験を行います。　両者が完全に1つのシンメトリーなピークにならない時は試料と標準品は同じ構造ではありません。<BR>
<BR>
　３．　試料と標準品が共打ちで完全に一致しなかった時はさらにエキソグリコシダーゼ消化によって試料の糖鎖構造を変化させ、　その都度適当な標準品と共打ちを行い比較します。　最終的に糖鎖がトリマンシルコアに一致すれば同定は完全です。　
糖鎖構造解析法の詳細は文献を参照してください。　参考文献(1,14,15)。</P>
<P align="center"><IMG src="image/fig4.png" border="0"><BR>
<BR>
<B><FONT size="+1">図4</FONT> </B>　<FONT size="+1">酵素消化を利用した構造解析</FONT></P>
<P><BR>
</P>
<P>　図４に実例を示します。<BR>
<BR>
　試料PA糖鎖のマップ上での位置　（緑十字）　が、上図のように3つの候補　（ここでは３つの赤点)　の丁度中間に来てしまい、どれとも決められない場合があります。さらにこの３者は分子質量も同一なので、　区別がむずかしいケースです。　
こういう時でも、　試料とそれぞれの標準品とをHPLCに共打ちすれば、　それだけで殆ど決まりますが、　さらに酵素消化を行えば万人を納得させることが出来ます。　右図のように3者をβ-N-Acetylhexosaminidase
(β-HexNAcase)　で消化するとマップ上で互いに明瞭に離れますので、元のものがどれだったか迷うことはありません。</P>
<P><BR>
<BR>
</P>
<P><A NAME="PARAM"><B><FONT size="+1">Unit Contributionのパラメーター化</FONT></B>　：</A><BR>
　HPLCのカラムからの糖鎖の溶出位置は、 規則性・再現性があり、
また、 その溶出位置は、 糖鎖ツリーを構成する各糖鎖残基ユニット
（現在は61種類） のカラムへの親和力 (Unit
Contribution = UC) 値の合計であると考えられます。　そこで、
このUC値の大きさを重回帰分析を行って算出し数値化しました。
パラメーター化の目的は、 以下の２つです。<BR>
　<BR>
　（１） 糖鎖の構造式が与えられた時、　それが既知の糖鎖でなくても、
マップ上のどのあたりに出てくるか、 実験する前に大体の見当がつく。<BR>
<BR>
　（２） 試料糖鎖の座標が、 マップ上の既知ものと一致しなかった場合でも、
その位置から、 糖鎖の推定ができる場合がある。<BR>
<BR>
　実際これらのパラメーターの値を使って未知の糖鎖の位置を予測した例を図５に説明します。<BR>
　<BR>
　以下の右上の構造式 ( コード番号　110.4F
)　については ODS 8.9, アミド 7.0 という実測値が知られていますが、右下に示すような、110.4Fから末端のガラクトース残基　(
図３の糖残基ユニット28 ) を除いた糖鎖のデータは記載がありません。
しかしUC値 (この場合は ODS 1.3, アミド　0.9）
を利用すれば簡単にそのマップ上の位置が ODS
7.6, アミド 6.1 というように推定できます。</P>
<P align="center"><BR>
<IMG src="image/fig5.png" border="0"><BR><BR>
<B><FONT size="+1">図５</FONT></B><FONT size="+1">　UC値を利用した未同定PA糖鎖の座標の推定</FONT></P>
<P><BR><BR>
</P>
<P><A NAME="CODE"><B><FONT size="+1">コード番号 ：</FONT></B></A><BR>
　個々のPA糖鎖に対してつけたコード番号の意味は下の図を参照して下さい。　ハイフン（－）より右の数字は中性糖部分についての番号です。</P>
<P align="center"><IMG src="image/fig6.png" width="730" height="347" border="0"><BR>
<B><FONT size="+1">図６</FONT></B>　<FONT size="+1">コード番号</FONT></P>
<P><BR><BR>
</P>
<P><A NAME="SYAJI"><B><FONT size="+1">謝辞　：</FONT></B></A><BR>
　この 2-D/3-D 糖鎖マップ法は、1980年代の開発の初期から実に大勢の方々の支持、援助により、今日の形に至りました。その方々に深く感謝しております。　特にお世話になった方々を以下に列記し、厚く御礼申しあげます。<BR>
<BR>
　荒田洋治先生は　NMR測定によりマップ法で推定した糖鎖構造が正しいという根拠を与えて下さいました。
Dr. Yuan Chuan Lee はマップ法における糖鎖の溶出位置に理論的根拠を与え、
特にUCのパラメーター化を推進して下さいました。　富谷昇、
中川裕章両博士はマップ法の開発のため献身的努力によって、
研究を支えて下さいました。 山口<SPAN style='font-size:10.5pt;mso-bidi-font-size:10.0pt;
font-family:"ＭＳ 明朝";mso-ascii-font-family:Century;mso-hansi-font-family:Century;
mso-bidi-font-family:"Times New Roman";mso-font-kerning:1.0pt;mso-ansi-language:
EN-US;mso-fareast-language:JA;mso-bidi-language:AR-SA'></SPAN>芳樹博士は本ウェブアプリケーション開発にあたり、
有益なディスカッションをして下さいました。
FCCAの皆様は1998年以来、 そのホームページにPA糖鎖の溶出位置データを発表する利便を与えて下さいました。　本アプリケーションの開発は、文部科学省・科学研究費
( 特定領域研究 ) および科学技術振興事業団・戦略的創造研究推進事業の支援によって行われました。</P>
<BR><BR>
<P><A NAME="Ref"><B><FONT size="+1">References</FONT></B></A>　：<BR>
<OL>
<LI>Tomiya, N., Awaya, J., Kurono, M., Endo, S., Arata, Y., and Takahashi, N. (1988)Analyses of N-linked oligosaccharides using a two dimensional mapping technique.<EM>Anal. Biochem</EM>. <STRONG>171</STRONG>, 73-90. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=3407923&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., and Tomiya, N. (1992) Analysis of N-linked oligosaccharides: Application of glycoamidase A in Handbook of <EM>Endoglycosidases and Glycoamidases</EM> (Takahashi, N., and Muramatsu, T., Eds.), pp. 199-332, CRC Press, Boca Raton, FL. 
<BR>
<LI>Ohsuga, H., Su, S. N., Takahashi, N., Yang, S-Y, Nakagawa, H., Shimada, I., Arata, Y., and Lee, Y. C. (1996) The carbohydrate moiety of the Bermuda grass antigen BG60: New oligosaccharides of plant origin. <EM>J. Biol. Chem.</EM> <STRONG>271</STRONG>, 26653-26658. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8900140&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Tezuka, K., Hayashi, M., Ishihara, H., Akazawa, T., and Takahashi, N. (1992) Studies on synthetic pathway of xylose containing N-linked oligosaccharides deduced from substrate specificities of the processing enzymes in sycamore cells (Acer pseudoplatanus L.). <EM>Eur. J. Biochem.</EM> <STRONG>203</STRONG>, 401-413. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=1531192&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Hsu, T. A., Takahashi, N., Tsukamoto, Y.,
  Kato, K., Shimada, I., Masuda, K., Whiteley,
  E. M., Fan, J. Q., Lee, Y. C., and Betenbaugh,
  M. J. (1997) Differential N-glycan patterns
  of secreted and intracellular IgG produced
  in <EM>Trichoplusia ni</EM> cells. <EM>J. Biol. Chem</EM>. <STRONG>272</STRONG>, 9062-9070. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=9083032&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Lee, K. B., Nakagawa, H., Tsukamoto, Y., Masuda, K., and Lee, Y. C. (1998) New N-glycans in horseradish peroxidase. <EM>Anal. Biochem.</EM> <STRONG>255</STRONG>, 183-187. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=9451502&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Tezuka, K., Hayashi, M., Ishihara, H., Nishimura, M., Onozaki, K., and Takahashi, N. (1993) Purification and substrate specificity of &beta;-xylosidase from sycamore cell (Acer pseudopatanus L.): Application for structural analysis of xylose-containing N-linked oligosaccharides. <EM>Anal. Biochem</EM>. <STRONG>211</STRONG>, 205-209. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8317695&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Nakagawa, N., Zheng, M., Hakomori, S., Tsukamoto, Y., Kawamura, Y., and Takahashi, N. (1996) Detailed oligosaccharide structures of human integrin &alpha;5&beta;1 analyzed by a three-dimensional mapping technique. <EM>Eur. J. Biochem</EM>. <STRONG>237</STRONG>, 76-85. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8620897&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Shikami, K., Matsuda, T., Nakamura, R., Shimada, I., and Arata, Y. (1993) A structural study of asparagine-linked oligosaccharide moiety of duck ovomucoid. <EM>Glycoconjugate J</EM>. <STRONG>10</STRONG>, 425-434. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8173333&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Shoji, H. Takahashi, N., Ishikawa, M., Shimada, I., Arata, Y, Nomoto, H., and Hayashi, K. (1992) Detailed structural analysis of asparagine-linked oligosaccharides of nicotinic acetylcholine receptor from Torpedo californica. <EM>Eur. J. Biochem</EM>. <STRONG>207</STRONG>, 631-641. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=1633814&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Ito, K., Takahashi, N., Takahashi, A., Shimada,
  I., Arata, Y., O'Brien, J., and Kishimoto,
  Y. (1993) Structural study of the oligosaccharide
  moieties of sphingolipid activator proteins,
  saposins A, C and D obtained from the spleen
  of a Gaucher patient. <EM>Eur. J. Biochem.</EM> <STRONG>215</STRONG>, 171-179. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8344278&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Tomiya, N., Lee, Y. C., Yoshida, T., Wada, Y., Awaya, J., Kurono, M., and Takahashi, N. (1991) Calculated two-dimensional sugar map of pyridylaminated oligosaccharides: Elucidation of the jack bean &alpha;-mannosidase digestion pathway of Man<SUB>9</SUB>GlcNAc<SUB>2</SUB>. <EM>Anal. Biochem</EM>. <STRONG>193</STRONG>, 90-100. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=2042746&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Wada, Y., Awaya, J., Kurono, M., and Tomiya, N. (1993) Two-dimensional elution map of GalNAc-containing N-linked oligosaccharides. <EM>Anal. Biochem</EM>. <STRONG>208</STRONG>, 96-109. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8434801&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Nakagawa, H., Fujikawa, K. Kawamura, Y., and Tomiya, N. (1995) Three-dimensional elution mapping of pyridylaminated N-linked neutral and sialyl oligosaccharides. <EM>Anal. Biochem.</EM> <STRONG>226</STRONG>, 139-146. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=7540366&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Nakagawa, H., Kawamura, Y., Kato, K., Shimada, I., Arata, Y., and Takahashi, N. (1995) Identification of neutral and sialyl N-linked oligosaccharide structures from human serum glycoproteins using three kinds of high-performance liquid chromatography. <EM>Anal. Biochem</EM>. <STRONG>226</STRONG>, 130-138. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=7785764&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Lee, K. B., Nakagawa, H.,
  Tsukamoto, Y., Kawamura, Y., Li, Y. T., and
  Lee, Y. C. (1995) Enzymatic sialylation of
  N-linked oligosaccharides using an &alpha;-(2,3)-specific
  trans-sialidase from Trypanosoma cruzi: Structural
  identification using a three-dimensional
  elution mapping technique. <EM>Anal. Biochem.</EM> <STRONG>230</STRONG>, 333-342. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=7503427&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Yamada, W., Masuda, K., Araki,
  H., Tsukamoto, Y., Galinha, A., Sautes, C.,
  Kato, K., and Shimada, I. (1998) N-glycan
  structures of a recombinant mouse soluble
  Fc &gamma; receptor II, <EM>Glycoconj J.</EM> <STRONG>15</STRONG>, 905-14. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=10052594&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Tomiya, N., Awaya, J., Kurono, M., Hanzawa,
  H., Shimada, I., Arata, Y., Yoshida, T.,
  and Takahashi, N. (1993) Structural Elucidation
  of a variety of GalNAc-containing N-linked
  oligosaccharides from human urinary kallidinogenase.
  <EM>J. Biol. Chem</EM>. <STRONG>268</STRONG>, 113-126. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=8416919&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Tomiya, N., Yamaguchi, T., Awaya, J., Kurono,
  M., Endo, S., Arata, Y., Takahashi, N., Ishihara,
  H., Mori, M., and Tejima, S. (1988) Structural
  analyses of asparagine-linked oligosaccharides
  of porcine pancreatic kallikrein. <EM>Biochemistry,</EM> <STRONG>27</STRONG>, 7146-7154. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=3196708&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Khoo, K. H., Suzuki, N., Johnson,
  J. R., and Lee, Y. C. (2001) N-glycan structures
  from the major glycoproteins of pigeon egg
  white , <EM>J Biol Chem.</EM> <STRONG>276</STRONG>, 23230-9. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=11285264&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Solal, J., Galinha, A., Fridman,
  W. H., Fridman, C., and Kato, K. (2002) N-Glycosylation
  profile of recombinant human soluble Fc &gamma;
  receptor III, <EM>Glycobiology.</EM> <STRONG>12</STRONG>, 1-8. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=12145191&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Tsukamoto, Y., Shiosaka, S.,
  Kishi, T., Hakoshima, T., Arata, Y., Yamaguchi,
  Y., Kato, K., and Shimada, I. (1999) N-glycan
  structures of murine hippocampus serinc protcasc,
  neuropsin, produced in <EM>Trichoplusia ni</EM> cells, <EM>Glycoconjugate J.</EM> <STRONG>16</STRONG>, 405-414. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=10737326&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Ailor, E., Takahashi, N., Tsukamoto, Y.,
  Masuda, K., Rahman, B. A., Jarvis, D. L.,
  Lee, Y. C., and Betenbaugh, M. J. (2000)
  N-glycan patterns of human transferrin produced
  in Trichoplusia ni insect cells effects of
  mammalian galactosyltransferase, <EM>Glycobiology.</EM> <STRONG>10</STRONG>, 837-47. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=10929010&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
<LI>Takahashi, N., Masuda, K., Hiraki, K., Yoshihara,
  K., Huang, H. H., Khoo, K. H., and Kato,
  K. (2003) N-glycan structures of squid rhodopsin
  : Existence of the &alpha;1-3 and &alpha;1-6
  di-fucosylated innermost GlcNAc residue in
  a molluscan glycoprotein, <EM>Eur. J. Biochem</EM>. <STRONG>270</STRONG>, 3627-2632. 
<A href="http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&db=PubMed&list_uids=12787029&dopt=Abstract" target="_blank">[PubMed]</A>
<BR>
</OL>
<BR>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"></P>
 			</TD>
            <TD width="10">&nbsp;</TD>
          </TR>
		  <TR>
		  	<TD colspan="3" height="2" align="center" bgcolor="white">
			</TD>
		  </TR>
          <TR>
            <TD colspan="10" align="center" bgcolor="blue">
			<%@ include file="include/footer.htm" %>
	        </TD>
          </TR>
        </TBODY>
      </TABLE>
      </TD>
    </TR>
  </TBODY>
</TABLE>
</CENTER>
</BODY>
</HTML>
