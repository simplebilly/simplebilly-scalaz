package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import ContactCreate._

case class ContactCreate (
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
certificateValidUntil: Option[LocalDate],
city: Option[String],
companyName: Option[String],
contactPersons: Option[AnyType],
contactType: ContactType,
country: Option[CountryCode],
creditLimit: Option[String],
creditorAccountSkr03: Option[String],
creditorAccountSkr04: Option[String],
currency: Option[String],
customFields: Option[AnyType],
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
lastContactDate: Option[LocalDate],
lastPurchaseDate: Option[LocalDate],
leitwegId: Option[String],
lifetimeValue: Option[String],
mandateDate: Option[LocalDate],
mandateReference: Option[String],
marketingConsent: Option[Boolean],
marketingConsentAt: Option[OffsetDateTime],
marketingConsentSource: Option[String],
mobile: Option[String],
name: String,
nextContactDate: Option[LocalDate],
notes: Option[String],
openingBalance: Option[String],
openingBalanceDate: Option[LocalDate],
orderReference: Option[String],
paymentBlock: Option[Boolean],
paymentGracePeriodDays: Option[Integer],
paymentMethods: Option[List[String]],
paymentTerms: Option[String],
phone: Option[String],
rating: Option[Integer],
salesRepresentative: Option[String],
sepaBatchBooking: Option[Boolean],
sepaSequenceType: Option[SepaSequenceType],
socialMedia: Option[AnyType],
source: Option[String],
state: Option[String],
street: Option[String],
streetNumber: Option[String],
supplierNumber: Option[String],
tags: Option[List[String]],
taxCountry: Option[CountryCode],
taxNumber: Option[String],
taxOffice: Option[String],
totalInvoices: Option[Integer],
totalRevenue: Option[String],
vatId: Option[String],
vatIdValidated: Option[Boolean],
vatIdValidationDate: Option[LocalDate],
website: Option[String],
zip: Option[String])

object ContactCreate {
  import DateTimeCodecs._

  implicit val ContactCreateCodecJson: CodecJson[ContactCreate] = CodecJson.derive[ContactCreate]
  implicit val ContactCreateDecoder: EntityDecoder[ContactCreate] = jsonOf[ContactCreate]
  implicit val ContactCreateEncoder: EntityEncoder[ContactCreate] = jsonEncoderOf[ContactCreate]
}
