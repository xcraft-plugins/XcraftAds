# XcraftAds
Ermöglicht dem Spieler eigene Werbung über einen Broadcaster im Chat anzuzeigen.

## Commands

> ### /ads help
>> zeigt dem Spieler Informationen über die Commands an.
>
> ### /ads create \<Nachricht>
>> lässt den Spieler eine Werbung erstellen.
>
> ### /ads list
>> listet dem Spieler seine Werbungen auf.

## Permissions

> ### /ads help
>> xcraftads.help 
>>
>> default: op
>
> ### /ads create \<Nachricht>
>> xcraftads.create
>>
>> default: op
>
> ### /ads list
>> xcraftads.list
>>
>> default: op

## Configuration

> ### interval
>> Der Interval in dem die Werbungen geschaltet werden in Minuten.
>>
>> default: 15
>
> ### broadcasts
>> Die Anzahl der Broadcasts einer Werbung.
>>
>> default: 10
>
> ### cost
>> Die Kosten für die Schaltung einer Werbung.
>>
>> default: 1000
>
> ### order
>> Die Reihenfolge in der die Werbungen geschaltet werden. 
>> <br>
>> Mögliche Reihenfolgen sind:
>> - "random" – Zufällige Reihenfolge
>> - "sorted" – Die Werbungen mit den meisten broadcasts zuerst
>>
>> default: "random"
