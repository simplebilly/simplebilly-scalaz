package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CustomerGroup._

case class CustomerGroup (
  description: Option[String],
/* Contact ids that are members of this group. */
  memberIds: Option[List[String]],
/* Rule description for membership, e.g. \"orders > 5 last 12 months\". */
  membershipFilter: Option[String],
/* Unique group name, e.g. \"VIP\", \"Wholesale\", \"Newsletter\". */
  name: String)

object CustomerGroup {
  import DateTimeCodecs._

  implicit val CustomerGroupCodecJson: CodecJson[CustomerGroup] = CodecJson.derive[CustomerGroup]
  implicit val CustomerGroupDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]
  implicit val CustomerGroupEncoder: EntityEncoder[CustomerGroup] = jsonEncoderOf[CustomerGroup]
}
