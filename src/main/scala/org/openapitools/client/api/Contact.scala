package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Contact._

case class Contact (
  accountHolder: Option[String],
acquisitionCost: Option[String],
addressSupplement: Option[String],
attention: Option[String],
bankName: Option[String],
bic: Option[String],
buyerReference: Option[String],
category: Option[String],
certificateAuthority: Option[String],
certificateNumber: Option[String],
certificateParagraph: Option[String],
certificateValidUntil: Option[String],
city: Option[String],
companyName: Option[String],
contactId: String,
contactPersons: AnyType,
contactType: String,
country: Option[String],
createdAt: String,
creditLimit: Option[String],
creditorAccountSkr03: Option[String],
creditorAccountSkr04: Option[String],
currency: Option[String],
customerNumber: Option[String],
debitorAccountSkr03: Option[String],
debitorAccountSkr04: Option[String],
defaultDebitorNumber: Option[String],
deliveryBlock: Option[Boolean],
department: Option[String],
discountDays: Option[Integer],
discountPercentage: Option[String],
donationReceiptEligible: Option[Boolean],
email: Option[String],
externalId: Option[String],
fax: Option[String],
iban: Option[String],
industry: Option[String],
isActive: Option[Boolean],
isMember: Option[Boolean],
isNonprofit: Option[Boolean],
lastContactDate: Option[String],
lastPurchaseDate: Option[String],
leitwegId: Option[String],
lifetimeValue: Option[String],
mandateDate: Option[String],
mandateReference: Option[String],
marketingConsent: Option[Boolean],
marketingConsentAt: Option[String],
marketingConsentSource: Option[String],
mobile: Option[String],
name: String,
nextContactDate: Option[String],
notes: Option[String],
openingBalance: Option[String],
openingBalanceDate: Option[String],
orderReference: Option[String],
paymentBlock: Option[Boolean],
paymentGracePeriodDays: Option[Integer],
paymentMethods: Option[List[String]],
paymentTerms: Option[String],
phone: Option[String],
rating: Option[Integer],
salesRepresentative: Option[String],
socialMedia: AnyType,
source: Option[String],
state: Option[String],
street: Option[String],
streetNumber: Option[String],
supplierNumber: Option[String],
tags: Option[List[String]],
taxCountry: Option[String],
taxNumber: Option[String],
taxOffice: Option[String],
totalInvoices: Option[Integer],
totalRevenue: Option[String],
updatedAt: Option[String],
vatId: Option[String],
vatIdValidated: Option[Boolean],
vatIdValidationDate: Option[String],
website: Option[String],
zip: Option[String])

object Contact {
  import DateTimeCodecs._

  implicit val ContactCodecJson: CodecJson[Contact] = CodecJson.derive[Contact]
  implicit val ContactDecoder: EntityDecoder[Contact] = jsonOf[Contact]
  implicit val ContactEncoder: EntityEncoder[Contact] = jsonEncoderOf[Contact]
}
