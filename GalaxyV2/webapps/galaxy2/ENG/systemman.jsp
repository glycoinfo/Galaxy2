<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html; charset=Windows-31J"%>
<%
%>

<HTML lang="en">
<HEAD>
<meta http-equiv="Content-Type"content="text/html;charset=iso-8859-1">
<meta name="robots" content="index,nofollow">
<TITLE>About this system</TITLE>
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
<P align="center"><B><FONT size="+3">Introduction</FONT></B></P>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"></P>
<UL>
  <LI><B><A href="#PRE">Preface</A></B>
  <LI><A href="#GU"><B>Glucose Unit (GU)</B></A>
  <LI><A href="#MAP"><B>The make up of the 2-D/3-D map</B></A>
  <LI><A href="#STRUCT"><B>Analyses of N-glycan structures</B></A>
  <LI><A href="#PARAM"><B>Parameterization of unit contribution</B></A>
  <LI><A href="#CODE"><B>Code Number</B></A>
  <LI><A href="#ACKNOW"><B>Acknowledgements</B></A>
</UL>
<P><BR><BR>
</P>
<P>&bull; <A  NAME="PRE"><B><FONT size="+1">Preface</FONT></B></A><BR>
We briefly explain the 2-D/3-D mapping method
which has been developed for the structural
determination of asparagine-linked oligosaccharides
(N-glycans) in glycoproteins.<BR>
In this method, N-glycans are released from
the protein portion and the reducing ends
are fluorecent labeled with 2-aminopyridine.
These pyridylamino (PA)-glycans are separated
by HPLC using three different columns sequentially;
and from the elution positions on three HPLC
columns, the structures of PA-glycans are
simultaneously estimated.<BR>
The structure of a sample PA-glycan can be
estimated by comparing its elution position
on the map with the positions of the known
reference N-glycans plotted on the 2-D map.
The sample PA-glycan and one of the candidate
reference PA-glycans are co-injected into
two HPLC columns to confirm a single peak.
Furthermore, the sample PA-glycan are digested
with several glycosidases, then the changes
of the elution positions are again compared
with those of the reference N-glycans. <BR>
This method is useful not only as an analytical
procedure for N-glycan structures, but also
as a means of isolating large scale samples
for NMR spectroscopy or MS spectrometry.<BR>
Approximately 1mg of glycoprotein is used
for the method. PA-oligosaccharides (pico
moles or femto moles) are used for one run
of HPLC analysis.<BR>
The identified N-glycan structures are coded
with by code numbers with alphaneumeric characters
(Code Number, e.g. 110.4F, or 3A1-300.8,
etc.)<BR>
The new Web application contains data on
approximately 500 different PA-glycans: It
includes the structures, HPLC elution positions
expressed in glucose units (GU) on ODS and
amide-silica columns, relative molecular
mass, code numbers, sources of samples, and
references.
<P><BR><BR>
</P>
<P>&bull; <A NAME="GU"><B><FONT size="+1">Glucose Unit ( GU )</FONT></B></A><BR>
GU expresses essentially the elution time
of a sample from an HPLC column. The elution
time expressed in real time or volume can
vary depending on the individual column,
its age, or the batches of buffers used.
The introduction of the GU is meant to reduce
such variations.</P>
<P align="center"><B><FONT size="+1"><A href="fig1.html" target="_blank"><IMG src="image/fig1.png" border="0" alt="ZOOM"></A><BR>
<BR>
</FONT></B><B><FONT size="+1">Fig .1</FONT> </B><FONT size="+1">Measurements of Glucose Unit (GU) values</FONT></P>
<P><BR>
</P>
<P>Let us explain how to express elution time
as a GU, using Fig.1. Both the ODS and the
amide columns are first calibrated respectively
with a commercial PA-derivatized isomalto-oligosaccharide
mixture. Numbers (4, 5, 6, etc.) indicate
the degree of glucose polymerization. Sample
PA-glycan is then applied to the column.
Red peaks show the elution positions of the
samples. The elution time of the sample compared
with those of the glucose oligomers and the
GU are estimated. The next step is plotting
the GU values; 14.7 on the X-axis and 6.7
on the Y-axis are plotted on the 2-D map
as coordinates (red dot) and compared with
the coordinates of known reference N-glycans
(blue dots) plotted on the 2-D map. <BR>
Since we first published 113 different N-glycan
structures and their GU values on the 2-D
map in 1988, in <I>Analytical Biochemistry</I> we have not had any need to revise them.
However, if you use columns different from
ours (Shim-pack CLC-ODS column and Amide-80
column), it may be difficult to obtain the
same GU values.</P>
<P><BR>
<BR>
</P>
<P>&bull; <A NAME="MAP"><B><FONT size="+1">The make up of th 2-D/3-D map</FONT></B></A><BR>
The 2-D mapping method is completely included
in the 3-D mapping method.<BR>
(1) The PA-glycan mixture is separated on
a DEAE (diethylaminoethyl) column according
to its sialic acid content into neutral,
mono-sialyl, di-sialyl, etc. This is the
first step in the 3-D mapping method.<BR>
(2) Next, using the two different types of
HPLC columns (an ODS and an amide column),
sample PA-glycans fractionated on the DEAE
column are further purified and their structures
are simultaneously estimated. The procedure
is called the 2-D mapping method. The elution
time on the ODS column is expressed as a
GU to be plotted on the X-axis. The GU value
on the ODS column depends on the fine structure
of each oligosaccharide.<BR>
Even oligosaccharides of the same molecular
size can be separated on the X-axis. Separation
profiles are very sharp. <BR>
(3) Each sample PA-glycan separated on the
ODS column is applied onto the amide column,
and the elution time is expressed as a GU
to be plotted on the Y-axis. The GU value
on the amide column (Y-axis) depends roughly
on the molecular mass of each oligosaccharide.
<BR>
(4) The coordinates of the sample PA-glycans
are plotted on the 2-D map.<BR>
(5) For each group of different sialylation,
the above processes (2)-(4) are repeated.
<BR>
Let us explain further using Fig. 2.<BR>
(a) and (b): When all the coordinates are
plotted for each sialylation group, a<BR>
2-D map is created for each of these groups
separated by the DEAE column. <BR>
(c) and (d): It is important that for each
2-D map the HPLC elution conditions used
( the composition of buffers and gradient
changes ) to obtain the X-and Y-coordinates
are completely identical, so the coordinates
can be transposed from layer to layer. If
we plot all the coordinates from all the
layers on a single 2-D map, the resultant
map is very confusing. To avoid such confusion,
3-D plotting consisting of layers of 2-D
maps is introduced, as shown in (d).</P>
<P align="center"><B><FONT size="+1"><IMG src="image/fig2.png" width="575" height="471" border="0"><BR>
<BR>
Fig. 2</FONT></B> <FONT size="+1">The make up of the 2-D/3-D map</FONT></P>
<P><BR>
<BR>
</P>
<P>&bull; <A NAME="STRUCT"><B><FONT size="+1">Analyses of N-glycan structures</FONT></B></A><BR>
N-glycan structure can be expressed by a
tree-like form which spreads its branches
on a trunk of a tri-mannosyl core structure.
The approximately 500 structures so far documented
can be expressed as a <B>Glycotree Diagram</B> that joins all 61 different units of sugar
residue.</P>
<P align="center"><B><FONT size="+1"><A href="odsparam.html" target="_blank"><IMG src="image/fig3ods.png" border="0" alt="ZOOM"></A><A href="amideparam.html" target="_blank"><IMG src="image/fig3amide.png" border="0" alt="ZOOM"></A><BR>
<BR>
Fig. 3</FONT></B> <FONT size="+1">Glycotree diagram with the UC values</FONT></P>
<P><BR>
</P>
<P>The structure of an unknown N-glycan is estimated
by comparing its position on the 3-D map
with the positions of the PA- reference N-glycans
plotted on the 2-D map.<BR>
(1) A few candidates whose coordinates coincide
with those of the sample PA-glycan within
allowable error (&plusmn;5%) are chosen
by a computer search.<BR>
(2) The sample PA-glycan and one of the candidate
reference PA-glycans are co-injected into
two different HPLC columns to confirm a single
peak.<BR>
(3) The sample PA-glycan and the candidate
reference PA-glycan are simultaneously digested
with several glycosidases. Their elution
positions are compared again. The comparison
is continued until both PA-glycans yield
the common trimannosyl core.</P>
<P align="center"><IMG src="image/fig4.png" border="0"><BR>
<BR>
<B><FONT size="+1">Fig. 4</FONT></B> <FONT size="+1">Structural analysis using a glycosidase digestion</FONT></P>
<P><BR>
</P>
<P>We will continue our explanation using Fig.
4.<BR>
It is sometimes necessary to go beyond a
direct comparison of the GU. For example,
the coordinates of an unknown sample (green
cross) are placed among three known structures
(red dots), and the molecular weight of the
three references are all the same. In these
cases, co-injection with a reference PA-oligosaccharide
is the most reliable solution. Moreover,
a digestion method using several glycosidases
is very useful. Although the elution positions
of the three candidates are very close, after
b-N-acetylhexosaminidase digestion, the elution
positions of the resultant three N-glycans
disperse as illustrated in Fig. 4. Therefore,
we can establish the originally unknown structure
by a series of transformations. </P>
<P><BR><BR>
</P>
<P>&bull; <A NAME="PARAM"><B><FONT size="+1">Parameterization of unit contribution</FONT></B></A><BR>
The basic assumption used in the paramerterization
of unit contribution is that the elution
position of a given PA-glycan is represented
by the sum of <B>the contribution of each component monosaccharide
unit</B> (unit contribution =UC). Calculation to
obtain UC parameters was carried out by a
linear multiple regeression analysis. All
61 different UC values obtained for ODS and
amide columns are diagrammatically expressed
in GU as shown in Fig. 3. <BR>
The purpose of the Parameterization of UC
is as follows:<BR>
(1) From a given structure, the GU value
of the N-glycan can be assumed. <BR>
(2) These calculated UC values are useful
in predicting glycan structure from an observed
GU on the 2-D map.<BR>
Let us explain the case (1) using Fig. 5.<BR>
Although code No. 110.4F (ODS 8.9, amide
7.0 ) exists on the 2-D map, the smaller
structure lacking galactose residue (unit
number 28) does not exist on the map. However,
if we use the UC value of the galactose residue
(ODS 1.3, amide 0.9) , the position of this
new structure on the map can be estimated
easily.</P>
<P align="center"><IMG src="image/fig5.png" border="0"><BR>
<BR>
<B><FONT size="+1">Fig. 5</FONT></B> <FONT size="+1">Prediction of coordinates of an unidentified
PA-glycan based on the UC values</FONT></P>
<P><BR><BR>
</P>
<P>&bull; <A NAME="CODE"><B><FONT size="+1">Code Number<BR>
</FONT></B></A>The code number of the PA-N-glycans consists
of a set of several elements with the following
meaning. The number to the right of the hyphen
(here 300.8) represents the neutral N-glycan
code number.</P>
<P align="center"><IMG src="image/fig6.png" border="0"></P>
<P align="center"><B><FONT size="+1">Fig. 6. Code Number</FONT></B></P>
<P><BR><BR>
</P>
<P>&bull; <A NAME="ACKNOW"><B><FONT size="+1">Acknowledgements</FONT></B></A><BR>
The 2-D/3-D mapping method has been developed
since 1980. We are greatly indebted to all
our collaborators for their generous support
and for their encouragement. Especially we
would like to express our sincere gratitude
to the following persons:<BR>
Prof. Yoji Arata who provided the structural
basis by NMR analyses for our proposed structures
obtained by the 2-D/3-D mapping method. Prof.
Yuan Chuan Lee who gave us advice on the
application of a theory related to &quot;UC&quot;
and who continues to offer useful comments
on our work. Dr. Hiroaki Nakagawa and Dr.
Noboru Tomiya who devotedly supported our
research during its difficult beginnings.
Dr. Yoshiki Yamaguchi who gave us helpful
advice in the development of this Web application.
Members of FCCA who for 5 years have given
us the opportunity to express our data related
to PA-glycans on their Website. This work
was supported by Grant-in-Aid for Scientific
Research from the Ministry of Education,
Culture, Sports, Science and Technology;
and CREST of Japan Science and Technology
Corporation.</P>
<BR><BR>
<P><A NAME="Ref"><B><FONT size="+1">References</FONT></B></A><BR>
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
  Lee, Y.C., and Betenbaugh, M. J. (2000) N-glycan
  patterns of human transferrin produced in
  Trichoplusia ni insect cells effects of mammalian
  galactosyltransferase, <EM>Glycobiology.</EM> <STRONG>10</STRONG>, 837-47. 
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
<CENTER><IMG src="image/beau_l2.gif" width="685" height="3" border="0"></CENTER>
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