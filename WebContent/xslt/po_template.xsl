<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:template match="purchaseOrder">


		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fop/extensions">

			<!-- Creator="html2fo" Version="0.4.2" -->

			<fo:layout-master-set>

				<fo:simple-page-master margin-right=".3cm"
					margin-left="2.0cm" margin-bottom="1.0cm" margin-top="3.0cm"
					page-width="21cm" page-height="29.7cm" master-name="first">


					<fo:region-body margin-bottom="3cm" margin-top="8.5cm" />
<fo:region-before extent="8.5cm"/>
					<fo:region-after extent="3cm"/>

				</fo:simple-page-master>

			</fo:layout-master-set>

			<fo:page-sequence master-reference="first" language="en"
				hyphenate="true">






	<fo:static-content flow-name="xsl-region-before">

										
						<fo:table text-align="left" table-layout="fixed">
							<fo:table-column column-width="13.95cm" />
							<fo:table-column column-width="3.15cm" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell border-style="solid" border-color="black"
										border-width="1pt" height="25pt">
										
										<fo:block font-weight="bold" font-size="15pt"
											space-before.optimum="1.5pt" space-after.optimum="1.5pt"
											 text-align="start"><fo:external-graphic content-height="55%" content-width="75%"
      	                     scaling="uniform"
      	                    
      	                     src="servlet-context:/SIPL-PO-Filtered_files/image001.jpg" />
											SCIGENICS (INDIA) PVT. LTD.
										</fo:block>
										<fo:block font-size="8pt"
											space-before.optimum="1.5pt" space-after.optimum="1.5pt"
											 text-align="center">Plot No. H-4/5/6, 3rd Cross Street, Nehru Nagar, Perungudi, Chennai-600096
</fo:block>
<fo:block font-size="8pt"
											space-before.optimum="1.5pt" space-after.optimum="1.5pt"
											 text-align="center">Voice: +91 - 44 - 2454 4100 - 4 Lines. Fax: +91- 44 - 2454 4105. Email: purchase@scigenics.in</fo:block>
									</fo:table-cell>
									<fo:table-cell border-style="solid" border-color="black"
										border-width="1pt">
										<fo:block line-height="12pt" font-size="10pt"
											space-before.optimum="1.5pt" space-after.optimum="1.5pt"
											keep-together="always" text-align="center" >
											<fo:external-graphic content-height="65%" content-width="55%"
      	                     scaling="uniform"
      	                    
      	                     src="servlet-context:/SIPL-PO-Filtered_files/scigenics_1.gif" />
											</fo:block>


									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell border-style="solid" border-color="black"
										border-width="1pt" number-columns-spanned="2">
										<fo:block line-height="12pt" font-size="10pt"
											space-before.optimum="1.5pt" space-after.optimum="1.5pt"
											keep-together="always" text-align="center">TIN No.:33550924587, GSTNo.: 33AAACS8529H1ZB </fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>

					

					<fo:block line-height="12pt" font-weight="bold" font-size="10pt"
						space-before.optimum="1.5pt" space-after.optimum="1.5pt"
						keep-together="always" text-align="center">PURCHASE ORDER</fo:block>

					<fo:table text-align="left" table-layout="fixed">
						<fo:table-column column-width="1.18cm" />
						<fo:table-column column-width="1.58cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.56cm" />
						<fo:table-column column-width="1.9cm" />
						<fo:table-column column-width="0.81cm" />
						<fo:table-column column-width="1.10cm" />
						<fo:table-column column-width="1.60cm" />
						<fo:table-column column-width="1.00cm" />
						<fo:table-column column-width="0.01cm" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always">Purchase Order No. :</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="4">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center" >
<xsl:value-of select="ponumber"></xsl:value-of></fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">PO Date :</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<xsl:value-of select="poDate"></xsl:value-of>
									</fo:block>
								</fo:table-cell>
								
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="15pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							
												<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="9pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always">Quotation Ref  No. :</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="4">
									<fo:block line-height="9pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center" >
<xsl:value-of select="qutrefno"></xsl:value-of></fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="9pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Reference Date :</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="9pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<xsl:value-of select="refDate"></xsl:value-of>
									</fo:block>
								</fo:table-cell>
							
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="15pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="13">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt"  text-align="center">
										
									</fo:block>
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt"  text-align="center" linefeed-treatment="preserve">
										
										<xsl:variable name="newline">
      <xsl:text>&#xA;</xsl:text>
    </xsl:variable>
    <xsl:variable name="MyVar">
      <xsl:choose>
        <xsl:when test="contains(//vendorDetails,'|')">
          <xsl:value-of select="concat(substring-before(//vendorDetails,'|'),$newline,substring-after(//vendorDetails,'|'))"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="vendorDetails"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:variable>
										<xsl:value-of select="$MyVar"></xsl:value-of>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="80pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" ></fo:block>
								</fo:table-cell>
							</fo:table-row>

	

							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-rows-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Sl. No.</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-rows-spanned="2"
									number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Descriptions</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-rows-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Quantity</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-rows-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">UOM</fo:block>
								</fo:table-cell>
								
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Rate</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Amount</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="28pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" width="1.9cm">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Rs.</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" width=".8cm">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">P.</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Rs.</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">P.</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="22pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>

							</fo:table-body>
							</fo:table>

				</fo:static-content>







				<fo:static-content flow-name="xsl-region-after">
<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />
									</fo:block>
<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />
									</fo:block>
					<fo:block text-align="center">           
 Page <fo:page-number/> of <fo:page-number-citation ref-id="last-page" />  </fo:block>    	


				</fo:static-content>



				<fo:flow flow-name="xsl-region-body">
<xsl:variable name=""></xsl:variable>
	
						<xsl:for-each select="items">
						
						<fo:table text-align="left" table-layout="fixed">
						<fo:table-column column-width="1.18cm" />
						<fo:table-column column-width="1.58cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.56cm" />
						<fo:table-column column-width="1.9cm" />
						<fo:table-column column-width="0.81cm" />
						<fo:table-column column-width="1.10cm" />
						<fo:table-column column-width="1.60cm" />
						<fo:table-column column-width="1.00cm" />
						<fo:table-column column-width="0.01cm" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" >	<xsl:value-of select="sno"></xsl:value-of></fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										>	<xsl:value-of select="description"></xsl:value-of></fo:block>

								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="60pt">
									<fo:block line-height="20pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" >	<xsl:value-of select="quantity"></xsl:value-of>
</fo:inline>
									</fo:block>


								</fo:table-cell>
								
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="60pt">
									<fo:block line-height="20pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="denom"></xsl:value-of>
</fo:inline>
									</fo:block>


								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="unitprice"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="unitpricepaise"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="totalcost"></xsl:value-of>
</fo:inline>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="totalcostpaise"></xsl:value-of>
										</fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="20pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							</fo:table-body>
							</fo:table>
							<xsl:choose>
							<xsl:when test="position() = last()">
							<fo:table text-align="left" table-layout="fixed">
						<fo:table-column column-width="1.18cm" />
						<fo:table-column column-width="1.58cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.30cm" />
						<fo:table-column column-width="1.56cm" />
						<fo:table-column column-width="1.9cm" />
						<fo:table-column column-width="0.81cm" />
						<fo:table-column column-width="1.10cm" />
						<fo:table-column column-width="1.60cm" />
						<fo:table-column column-width="1.00cm" />
						<fo:table-column column-width="0.01cm" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Packing and Forwarding
									</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" >
</fo:inline>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />
										

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/packingForwarding"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/packingForwardingpaise"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
						
							<xsl:if test="not(/purchaseOrder/gst)"> 
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Excise Duty</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/excisePecentage"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/exciseAmount"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/exciseAmountpaise"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							
							
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">VAT CST</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/vatPercentage"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/vatAmount"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/vatAmountpaise"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							</xsl:if>
							<xsl:if test="/purchaseOrder/gst">
								<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">GST</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/gst"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/gstAmount"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/gstAmountpaise"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							</xsl:if>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Total</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-weight="bold"
										font-size="10pt" space-before.optimum="1.5pt"
										space-after.optimum="1.5pt" keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/totalCost"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" ><xsl:value-of select="/purchaseOrder/totalCostpaise"></xsl:value-of></fo:inline>

									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Payment Terms</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="11">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										 text-align="start">	<xsl:value-of select="/purchaseOrder/paymentTerms"></xsl:value-of>
										
										</fo:block>
								</fo:table-cell>

								<fo:table-cell>
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Delivery Date</fo:block>
														
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
					
										
										<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										 text-align="center" >	<xsl:value-of select="/purchaseOrder/deliveryDate"></xsl:value-of>
										
										</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Insurance</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="5">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										 text-align="start">	<xsl:value-of select="/purchaseOrder/insurance"></xsl:value-of>
										
										</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="29pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>


							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="2">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Mode of Dispatch</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="3">
								<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										 text-align="start">	<xsl:value-of select="/purchaseOrder/modeOfDispatch"></xsl:value-of>
										
										</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="8">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always">Special Conditions :</fo:block>
										<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										 text-align="start">	<xsl:value-of select="/purchaseOrder/specialConditions"></xsl:value-of>
										
										</fo:block>
										
										
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" height="29pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>



							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="4">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="start">Support Documents
										
										</fo:block>
											<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										 text-align="start">	<xsl:value-of select="/purchaseOrder/supportDocuments"></xsl:value-of>
										
										</fo:block>
								</fo:table-cell>

								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="9" height="74pt">

									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">For SCIGENICS (INDIA)
										PRIVATE LTD.</fo:block>
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />
									</fo:block>
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />
									</fo:block>
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">
										<fo:inline white-space-collapse="false" />
									</fo:block>
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="40.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Authorised Signatory
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-color="black"
									border-width="1pt" number-columns-spanned="13">
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center">Please Acknowledge the
										Purchase order within 5 working days.
										FMT/PR11/Rev.3
									</fo:block>
								</fo:table-cell>

								<fo:table-cell>
									<fo:block line-height="12pt" font-size="10pt"
										space-before.optimum="1.5pt" space-after.optimum="1.5pt"
										keep-together="always" text-align="center" />
								</fo:table-cell>
							</fo:table-row>

						</fo:table-body>
					</fo:table>
							
							</xsl:when>
							<xsl:otherwise>
							<xsl:if test="(position() mod 3) =0">
							<xsl:choose>
							<xsl:when test="position() != last()">
							<fo:block page-break-before="always"/>
							</xsl:when>
							</xsl:choose>
							</xsl:if>
							
							</xsl:otherwise>
							</xsl:choose>
							
							</xsl:for-each>
									<fo:block id="last-page">
</fo:block>		
				</fo:flow>

			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>

